package pak.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pak.beans.MyBean;
import pak.beans.MyBean2;
import pak.interceptors.MyAspect;
import pak.interceptors.BeanPostProc;
import pak.interceptors.MyEventHandler;

@Configuration
@ComponentScan(basePackages = {"pak.beans", "pak.interceptors", "pak.jdbctemplate"})
public class MyConfig {

    @Bean(initMethod = "init")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //@Lazy
    public MyBean myBean() {
        MyBean mb = new MyBean();
        mb.setName("hello world");
        return mb;
    }

    @Bean
    public MyAspect myAspect() {
        return new MyAspect();
    }

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator aspectJAutoProxyCreator() {
        return new AnnotationAwareAspectJAutoProxyCreator();
    }

    @Bean
    public DriverManagerDataSource DriverManagerDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }

    @Bean
    public JdbcTemplate JdbcTemplate() {
        return new JdbcTemplate(DriverManagerDataSource());
    }

//    @Bean
//    public BeanPostProc postProcBean() {
//        return new BeanPostProc();
//    }

//    @Bean
//    public MyEventHandler myEventHandler() {
//        return new MyEventHandler();
//    }

}
