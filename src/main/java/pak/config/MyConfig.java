package pak.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pak.aop.MyBean;
import pak.aop.MyBean3;

@Configuration
@ComponentScan(basePackages = {"pak.aop", "pak.jdbctemplate"})
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

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(driverManagerDataSource());
    }

}
