package pak.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class BeanPostProc implements BeanPostProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("BeforeInit : " + beanName);
        return bean;  // you can return any other object as well
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("AfterInit : " + beanName);
        return bean;  // you can return any other object as well
    }

}
