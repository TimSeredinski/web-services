package com.epam.travel_agency.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Component
@Qualifier("application")
public class HikariDBUtil implements GenericDataSource{
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_URL = "db.url";

    private static HikariDataSource dataSource;
    private static HikariConfig config = new HikariConfig();

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/database.properties"));
            config.setJdbcUrl(properties.getProperty(DB_URL));
            config.setUsername(properties.getProperty(DB_USERNAME));
            config.setPassword(properties.getProperty(DB_PASSWORD));

            dataSource = new HikariDataSource(config);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Bean
    public DataSource getDataSource() {
        return dataSource;
    }
}
