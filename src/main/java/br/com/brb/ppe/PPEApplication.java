package br.com.brb.ppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class PPEApplication extends SpringBootServletInitializer {

    private static final String PROFILE_WEBLOGIC = "weblogic";
    private static final String PROFILE_DEFAULT = "default";

    public static void main(String... args) {
        SpringApplication.run(PPEApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.profiles(PROFILE_DEFAULT, PROFILE_WEBLOGIC);
        return application.sources(PPEApplication.class);
    }

}
