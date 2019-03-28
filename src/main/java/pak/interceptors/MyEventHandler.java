package pak.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

//@Component
public class MyEventHandler implements ApplicationListener<ContextStartedEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void onApplicationEvent(ContextStartedEvent event) {
        logger.info("ContextStartedEvent Received");
    }

    public void onApplicationEvent(ContextStoppedEvent event) {
        logger.info("ContextStoppedEvent Received");
    }

}
