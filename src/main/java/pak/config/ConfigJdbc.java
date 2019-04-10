package pak.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"pak.jdbctemplate"})
@PropertySource("classpath:app.config")
public class ConfigJdbc {

    @Value("${mysql.url:defaultValueGoesHere}")
    String url;
    @Value("${mysql.user}")
    String user;
    //@Value("${mysql.pass}")
    //String pass;

    @Autowired
    private Environment env;

    //register PropertySourcesPlaceholderConfigurer
    //in order to resolve ${...} placeholders
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DriverManagerDataSource driverManagerDataSource(/*@Value("${mysql.user}") String user*/) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(env.getProperty("mysql.pass"));
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(driverManagerDataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(driverManagerDataSource());
    }

}
