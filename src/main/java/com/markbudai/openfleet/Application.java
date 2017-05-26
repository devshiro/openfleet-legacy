package com.markbudai.openfleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Entry point of the OpenFleet Application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * Spring Boot executable jar entry point.
     * @param args Command Line arguments parsed by the {@code SpringApplication.run} method.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}