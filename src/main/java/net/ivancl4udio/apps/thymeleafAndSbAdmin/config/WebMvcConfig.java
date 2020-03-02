package net.ivancl4udio.apps.thymeleafAndSbAdmin.config;

import net.ivancl4udio.apps.thymeleafAndSbAdmin.interceptor.UrlLocaleInterceptor;
import net.ivancl4udio.apps.thymeleafAndSbAdmin.resolver.UrlLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean(name = "messageSource")
    public MessageSource getMessageResource()  {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();

        // Read i18n/messages_xxx.properties file.
        // For example: i18n/messages_pt_BR.properties
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }

    // To solver URL like:
    // /SomeContextPath/en/login2
    // /SomeContextPath/vi/login2
    // /SomeContextPath/fr/login2
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        LocaleResolver resolver = new UrlLocaleResolver();
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();

        registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/pt_BR");
    }
}
