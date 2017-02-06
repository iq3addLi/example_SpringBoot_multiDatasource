package jp.co.addli.config;

import jp.co.addli.repository.DataSourceImplRepository;
import jp.co.addli.repository.DataSourceRepository;
import jp.co.addli.repository.UserRepository;
import jp.co.addli.repository.UserImplRepository;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Project:example_SpringBoot_multiDatasource Created by iq3 on 2017/02/06.
 */

@Configuration
@ComponentScan(basePackages="jp.co.addli")
public class DataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.secondDataSource")
    public DataSource secondaryDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        return dataSource;
    }

    @Bean
    public UserRepository getUserRepository() {
        return new UserImplRepository( getDataSourceRepository() );
    }

    @Bean
    public DataSourceRepository getDataSourceRepository() {
        List<DataSource> list = new ArrayList<>();
        list.add( primaryDataSource() );
        list.add( secondaryDataSource() );
        return new DataSourceImplRepository( list );
    }
}
