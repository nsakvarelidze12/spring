package pak.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBean3 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name = "my bean 3";

    public void printName() {
        logger.info("{} {}", name, this.hashCode());
    }

    public String getName() {
        return name;
    }

}
