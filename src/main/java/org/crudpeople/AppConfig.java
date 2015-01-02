package org.crudpeople;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource("classpath:mongodb.properties")
@EnableMongoRepositories(basePackages = "org.crudpeople.repositories")
@ComponentScan(basePackages = {"org.crudpeople.controller", "org.crudpeople.service"})
public class AppConfig extends WebMvcConfigurationSupport {

    @Autowired
    private Environment environment;

    /**
     * Registra um controlador para a camada de vis&atilde;o.
     *
     * @param registry o registro administrado pelo spring
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * Registra uma manipulador para a camada de vis&atilde;o.
     *
     * @param registry o registro administrado pelo spring
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("resources/");
    }

    /**
     * Mapeia todas as p&aacute;ginas JSP.
     *
     * @return o resolver da camada vis&atilde;o
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new MongoClient(environment.getProperty("database.host"));
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongo(), environment.getProperty("database.name"));
    }
}
