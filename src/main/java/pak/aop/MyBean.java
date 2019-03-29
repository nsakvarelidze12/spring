package pak.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name = "my bean";
    private MyBean3 myBean3;

    public void init() {
        logger.info("init {}", name);
    }

    public void destroy() {
        logger.info("destroy {}", name);
    }

    public void printName() {
        logger.info("{} {}", name, this.hashCode());
    }

    public void setOtherBean(MyBean3 myBean3) {
        this.myBean3 = myBean3;
    }

    public void callOtherBean() {
        myBean3.printName();
    }

}
