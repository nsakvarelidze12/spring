package pak.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void welcomeMessage() {
        logger.info("second bean welcome");
    }
}
