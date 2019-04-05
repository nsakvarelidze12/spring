package pak.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pak.aop.MyBean;
import pak.aop.MyBean3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@ComponentScan(basePackages = {"pak.aop", "pak.jdbctemplate", "pak.hibernate"})
@PropertySource("classpath:app.config")
public class MyConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Lazy
    public MyBean myBean() {
        MyBean mb = new MyBean();
        //not DI
        //mb.setOtherBean(new MyBean3());
        mb.setOtherBean(myBean3());
        return mb;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MyBean3 myBean3() {
        return new MyBean3();
    }

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator aspectJAutoProxyCreator() {
        return new AnnotationAwareAspectJAutoProxyCreator();
    }

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

    // container managed
//    @PersistenceContext(unitName = "myUnit")
//    private EntityManager em;

}
