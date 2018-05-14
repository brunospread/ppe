package br.com.brb.ppe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@Order(-1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String NOME_REALM = "appreferencia";
    private static final String ENDPOINT_OAUTH_AUTHORIZE = "/oauth/authorize";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.httpBasic().realmName(NOME_REALM).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                        .requestMatchers().antMatchers(ENDPOINT_OAUTH_AUTHORIZE)
                    .and()
                        .authorizeRequests().antMatchers(ENDPOINT_OAUTH_AUTHORIZE)
                .authenticated()
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll();
        // @formatter:on

    }


}
