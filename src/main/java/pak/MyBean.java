package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    @Autowired
    private MyBean2 myBean2;

    @PostConstruct
    public void init() {
        logger.info("init");
    }

    // Destroy method is not called for beans of scope prototype
    @PreDestroy
    public void destroy() {
        logger.info("destroy");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void testMyBean2() {
        myBean2.welcomeMessage();
    }

}
