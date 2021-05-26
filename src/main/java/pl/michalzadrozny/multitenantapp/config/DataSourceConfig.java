package pl.michalzadrozny.multitenantapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.michalzadrozny.multitenantapp.util.RoutingDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfig(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        RoutingDataSource customDataSource = new RoutingDataSource();
        customDataSource.setTargetDataSources(dataSourceProperties.getDatasources());
        return customDataSource;
    }
}