package pl.michalzadrozny.multitenantapp.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Value("${tenants.default}")
    private String defaultDatabase;

    @Override
    protected Object determineCurrentLookupKey() {

        String tenantId = ThreadDatabaseStorage.getTenantId();

        if(tenantId == null){
            return defaultDatabase;
        }
        return tenantId;
    }

}