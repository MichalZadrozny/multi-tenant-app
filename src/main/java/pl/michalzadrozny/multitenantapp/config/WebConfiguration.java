package pl.michalzadrozny.multitenantapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.michalzadrozny.multitenantapp.util.HeaderDatabaseInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final HeaderDatabaseInterceptor headerDatabaseInterceptor;

    public WebConfiguration(HeaderDatabaseInterceptor headerDatabaseInterceptor) {
        this.headerDatabaseInterceptor = headerDatabaseInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(headerDatabaseInterceptor);
    }
}
