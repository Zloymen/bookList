package com.perfect.booklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Zloy on 16.08.2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.perfect.booklist")
@PropertySource(value = { "classpath:application.properties" })
@Import(SecurityConfig.class)
public class BookListConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/include/**").addResourceLocations("/include/");
        registry.addResourceHandler("/app/**").addResourceLocations("/resources/app/");
        registry.addResourceHandler("/build/**").addResourceLocations("/resources/build/");
        registry.addResourceHandler("/ext/**").addResourceLocations("/resources/ext/");
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/classic/**").addResourceLocations("/resources/classic/");

        registry.addResourceHandler("/export/**").addResourceLocations( env.getProperty("file.external"));
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}
