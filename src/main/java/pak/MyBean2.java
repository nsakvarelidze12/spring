package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@PostConstruct
    public void init() {
        logger.info("second bean init");
    }

    public void welcomeMessage() {
        logger.info("second bean welcome");
    }
}
