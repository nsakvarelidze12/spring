package pak;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class MyConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //@Lazy
    public MyBean myBean() {
        MyBean mb = new MyBean();
        mb.setName("hello world");
        return mb;
    }

    @Bean(initMethod = "init")
    public MyBean2 myBean2() {
        return new MyBean2();
    }

    @Bean
    public MyAspect myAspect() {
        return new MyAspect();
    }

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator aspectJAutoProxyCreator() {
        return new AnnotationAwareAspectJAutoProxyCreator();
    }

//    @Bean
//    public PostProcBean postProcBean() {
//        return new PostProcBean();
//    }

//    @Bean
//    public MyEventHandler myEventHandler() {
//        return new MyEventHandler();
//    }

}
