package br.com.brb.ppe.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.brb.framework.web.rest.handler.CustomPageableHandlerMethodArgumentResolver;
import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;



@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SpecificationArgumentResolver());
        argumentResolvers.add(new SortHandlerMethodArgumentResolver());
        argumentResolvers.add(pageableHandlerMethodArgumentResolver());
    }

    private CustomPageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver() {
        CustomPageableHandlerMethodArgumentResolver handler = new CustomPageableHandlerMethodArgumentResolver();
        handler.setPageParameterName("page");
        handler.setSizeParameterName("limit");
        return handler;
    }

}
