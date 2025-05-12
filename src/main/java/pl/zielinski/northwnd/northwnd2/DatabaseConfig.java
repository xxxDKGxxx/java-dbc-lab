package pl.zielinski.northwnd.northwnd2;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Bean
    public HikariConfig dataBaseConfig()
    {
        HikariConfig conifig = new HikariConfig();
        conifig.setJdbcUrl("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;encrypt=true;trustServerCertificate=true;database=NORTHWND");
        conifig.setUsername("sa");
        conifig.setPassword("wasze_haslo");
        // i driver do polaczen
        return conifig;
    }

    @Bean
    public HikariDataSource hikariDataSource(HikariConfig config)
    {
        return new HikariDataSource(config);
    }
}
