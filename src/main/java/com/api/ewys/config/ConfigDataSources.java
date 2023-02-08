package com.api.ewys.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;


/**
 * Формирует датасурсы по имеющемся в энвайронменте параметрам.
 * Может быть подменён конфигуом на уровне тест-контейнеров, что бы там использовать свои реквизиты
 */

@Slf4j
@Profile("!junit")
@Import(value = {ConfigDbCommon.class})
@Configuration
public class ConfigDataSources {
    @Value("${app.db.postgres.url}")
    private String url;
    @Value("${app.db.postgres.user}")
    private String user;
    @Value("${app.db.postgres.password}")
    private String password;
    @Value("${app.db.postgres.pool-size}")
    private Integer poolSize;

    @Bean("dataSource")
    protected DataSource frapDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(Driver.class.getName());

        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        ds.setMaximumPoolSize(poolSize);
        log.info("Datasource created!");
        return ds;
    }
}
