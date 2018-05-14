package br.com.brb.ppe.config;

import java.util.Properties;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

public abstract class AbstractDatabaseConfiguration implements EnvironmentAware {

    public static final String JNDI_NAME = "jndi-name";

    public static final String SPRING_DATASOURCE = "spring.datasource.";

    public static final String SPRING_JPA_PROPERTIES = "spring.jpa.properties.";

    public static final String VALIDATE = "validate";

    public static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    public static final String HIBERNATE_DIALECT = "hibernate.dialect";

    public static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    public static final String HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";

    protected RelaxedPropertyResolver jpaPropertyResolver;

    protected RelaxedPropertyResolver dataSourcePropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.jpaPropertyResolver = new RelaxedPropertyResolver(environment, SPRING_JPA_PROPERTIES);
        this.dataSourcePropertyResolver = new RelaxedPropertyResolver(environment, SPRING_DATASOURCE);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    protected Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty(HIBERNATE_HBM2DDL_AUTO,
                jpaPropertyResolver.getProperty(HIBERNATE_HBM2DDL_AUTO, VALIDATE));
        properties.setProperty(HIBERNATE_DIALECT, jpaPropertyResolver.getProperty(HIBERNATE_DIALECT));
        properties.setProperty(HIBERNATE_DEFAULT_SCHEMA, jpaPropertyResolver.getProperty(HIBERNATE_DEFAULT_SCHEMA));
        properties.setProperty(HIBERNATE_SHOW_SQL,
                jpaPropertyResolver.getProperty(HIBERNATE_SHOW_SQL, Boolean.FALSE.toString()));
        properties.setProperty(HIBERNATE_FORMAT_SQL,
                jpaPropertyResolver.getProperty(HIBERNATE_FORMAT_SQL, Boolean.FALSE.toString()));
        return properties;
    }
}
