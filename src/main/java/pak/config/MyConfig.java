package pak.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pak.beans.MyBean;
import pak.beans.MyBean3;

@Configuration
@ComponentScan(basePackages = {"pak.beans", "pak.interceptors", "pak.jdbctemplate"})
public class MyConfig {

    @Bean(initMethod = "init")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //@Lazy
    public MyBean myBean() {
        MyBean mb = new MyBean();
        mb.setOtherBean(new MyBean3());
        return mb;
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

//    @Bean
//    public BeanPostProc beanPostProc() {
//        return new BeanPostProc();
//    }

//    @Bean
//    public MyEventHandler myEventHandler() {
//        return new MyEventHandler();
//    }

}
