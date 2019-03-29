package pak.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyBean3 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name = "my bean 3";

    public void printName() {
        logger.info("{} {}", name, this.hashCode());
    }

}
