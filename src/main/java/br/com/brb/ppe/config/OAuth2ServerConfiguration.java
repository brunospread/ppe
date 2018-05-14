package br.com.brb.ppe.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import br.com.brb.framework.autenticacao.common.SGAUtil;
import br.com.brb.framework.autenticacao.handler.AjaxLogoutSuccessHandler;
import br.com.brb.framework.autenticacao.handler.Http401UnauthorizedEntryPoint;
import br.com.brb.framework.autenticacao.provider.ActiveDirectorySGAAuthenticationProvider;

@Configuration
public class OAuth2ServerConfiguration {


    private static String applicationName;

    @Value("${spring.application.name}")
    public void setApplicationName(String name) {
        this.applicationName = name;
    }

    @Bean
    public TokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }

    @Configuration
    @EnableAuthorizationServer
    public static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


        @Value("${authorization.timeout.refreshToken}")
        private int refreshTokenTimeout;

        @Value("${authorization.timeout.token}")
        private int tokenTimeout;

        @Value("${authorization.activeDirectoryDomain}")
        private String activeDirectoryDomain;

        @Value("${authorization.activeDirectoryUrl}")
        private String activeDirectoryUrl;

        @Autowired
        private SGAUtil sgaUtil;

        @Autowired
        private TokenStore tokenStore;

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private AuthenticationProvider authenticationProvider;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            clients.inMemory().withClient(applicationName).secret(applicationName)
                    .authorizedGrantTypes("password", "refresh_token", "implicit").scopes("read,write")
                    .resourceIds(applicationName).accessTokenValiditySeconds(tokenTimeout)
                    .refreshTokenValiditySeconds(refreshTokenTimeout);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
            endpoints.authenticationManager(authenticationManager()).reuseRefreshTokens(false).tokenStore(tokenStore)
                    .userDetailsService(userDetailsService);

        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        }

        protected AuthenticationManager authenticationManager() {
            return new ProviderManager(Arrays.asList(authenticationProvider));
        }

        @Bean
        public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {

            ActiveDirectorySGAAuthenticationProvider provider = new ActiveDirectorySGAAuthenticationProvider(
                    activeDirectoryDomain, activeDirectoryUrl);
            provider.setConvertSubErrorCodesToExceptions(true);
            provider.setUseAuthenticationRequestCredentials(true);
            provider.setSGAUtil(sgaUtil);

            return provider;
        }

    }

    @Configuration
    @EnableResourceServer
    public static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        private static final String API_V1_FUNDOS = "/api/v1.0.0/fundos.*";

        @Autowired
        private Http401UnauthorizedEntryPoint authenticationEntryPoint;

        @Autowired
        private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

        @Autowired
        private TokenStore tokenStore;


        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.tokenStore(tokenStore).resourceId(applicationName);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                    .and().logout()
                            .logoutUrl("/api/logout")
                            .logoutSuccessHandler(ajaxLogoutSuccessHandler)
                    .and().csrf().disable().headers().frameOptions().disable()
                    .and().sessionManagement()
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().authorizeRequests()
                            .regexMatchers(HttpMethod.GET, "/api/security/currentuser/profiles")
                                    .authenticated()

                    // Configuracao do acessos a api de negocio
                            .regexMatchers(HttpMethod.GET, API_V1_FUNDOS)
                                    .authenticated()
                            .regexMatchers(HttpMethod.POST, API_V1_FUNDOS)
                                     .authenticated()
                            .regexMatchers(HttpMethod.PUT, API_V1_FUNDOS)
                                     .authenticated()
                            .regexMatchers(HttpMethod.DELETE, API_V1_FUNDOS)
                                     .authenticated();
            // @formatter:on

        }

    }

}
