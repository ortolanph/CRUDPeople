package org.crudpeople;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.net.UnknownHostException;

@EnableWebMvc
@Configuration
@PropertySource("classpath:mongodb.properties")
@EnableMongoRepositories(basePackages = "org.crudpeople.repositories")
@ComponentScan(basePackages = {"org.crudpeople.controller", "org.crudpeople.service"})
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    public static final String URI_MONGO = "mongodb://%s:%s@%s:%s/%s";

    /**
     * Registra um controlador para a camada de vis&atilde;o.
     *
     * @param registry o registro administrado pelo spring
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * Registra uma manipulador para a camada de vis&atilde;o.
     *
     * @param registry o registro administrado pelo spring
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
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
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");

        return resolver;
    }


    @Bean
    public MongoDbFactory factory() throws UnknownHostException {
        String uriMongo = String.format(
                URI_MONGO,
                environment.getProperty("mongo.user"),
                environment.getProperty("mongo.password"),
                environment.getProperty("mongo.host"),
                environment.getProperty("mongo.port"),
                environment.getProperty("mongo.db"));

        MongoClientURI mongoClientURI = new MongoClientURI(uriMongo);

        SimpleMongoDbFactory myFactory = new SimpleMongoDbFactory(mongoClientURI);

        return myFactory;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(factory());
    }
}
