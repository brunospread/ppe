package br.com.brb.ppe.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.jta.WebLogicJtaTransactionManager;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
        "br.com.brb.ppe" }, repositoryImplementationPostfix = "Impl",
                transactionManagerRef = "transactionManager")
@Profile("weblogic")
@ConditionalOnExpression("${spring.jta.enabled}==true")
public class JtaDatabaseConfiguration extends DatabaseConfiguration {

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJtaDataSource(dataSource());
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        em.setPackagesToScan(new String[] {"br.com.brb.ppe"});
        return em;
    }

    @Bean
    public JtaTransactionManager transactionManager() {
        return new WebLogicJtaTransactionManager();
    }

    @Override
    protected Properties additionalProperties() {
        Properties properties = super.additionalProperties();
        properties.setProperty("hibernate.transaction.jta.platform",
                "org.hibernate.engine.transaction.jta.platform.internal.WeblogicJtaPlatform");
        return properties;
    }

}
