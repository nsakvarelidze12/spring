package pak.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name = "my bean";
    private MyBean3 myBean3;

    @PostConstruct
    public void init() {
        logger.info("init");
    }

    // Destroy method is not called for beans of scope prototype
    @PreDestroy
    public void destroy() {
        logger.info("destroy");
    }

    public void printName() {
        logger.info("{} {}", name, this.hashCode());
    }

    public String getName() {
        return name;
    }

    public void setOtherBean(MyBean3 myBean3) {
        this.myBean3 = myBean3;
    }

    public void callOtherBean() {
        myBean3.printName();
    }

}
