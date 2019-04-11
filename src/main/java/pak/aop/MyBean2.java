package pak.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myBean2")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyBean2 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("my bean 2")
    private String name;

    private MyBean3 myBean3;

    @PostConstruct
    public void init() {
        logger.info("init {}", name);
    }

    // Destroy method is not called for beans of scope prototype
    @PreDestroy
    public void destroy() {
        logger.info("destroy {}", name);
    }

    public void printName() {
        logger.info("{} {}", name, this.hashCode());
    }

    @Autowired
    public void setOtherBean(MyBean3 myBean3) {
        this.myBean3 = myBean3;
    }

    public void callOtherBean() {
        myBean3.printName();
    }

}
