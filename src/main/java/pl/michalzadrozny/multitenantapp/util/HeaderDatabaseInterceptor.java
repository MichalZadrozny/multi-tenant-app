package pl.michalzadrozny.multitenantapp.util;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class HeaderDatabaseInterceptor implements WebRequestInterceptor {

    public static final String DATABASE_HEADER = "Database";

    @Override
    public void preHandle(WebRequest request) {
        ThreadDatabaseStorage.setTenantId(request.getHeader(DATABASE_HEADER));
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) {
        ThreadDatabaseStorage.clear();
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) {

    }
}