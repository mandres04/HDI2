package mx.com.hdi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DataSourceConfig {
	@Bean(name = "hikariDataSource")
    public DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        HikariDataSource dataSource;
        config.setJdbcUrl("jdbc:oracle:thin:@52.204.195.188:1521:ORCL1");
        config.setUsername("MTZ");
        config.setPassword("UserMtz=01");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
        return dataSource;
    }
}
