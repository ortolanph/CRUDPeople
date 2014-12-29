package org.crudpeople;

import org.crudpeople.dao.PessoaDAO;
import org.crudpeople.dao.impl.PessoaDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//@PropertySource("crudpeople.properties")
@ComponentScan(basePackages = {"org.crudpeople.controller", "org.crudpeople.service"})
public class AppConfig extends WebMvcConfigurationSupport {

//    @Autowired
//    private Environment env;

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
    public PessoaDAO pessoaDAO() {
        return new PessoaDAOImpl();
    }
}

