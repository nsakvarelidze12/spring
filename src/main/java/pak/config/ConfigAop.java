package pak.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pak.aop.MyBean;
import pak.aop.MyBean3;

@Configuration
@ComponentScan(basePackages = {"pak.aop"})
public class ConfigAop {

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

}
