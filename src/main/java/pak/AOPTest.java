package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pak.beans.MyBean;
import pak.config.MyConfig;

public class AOPTest {

    private static Logger logger = LoggerFactory.getLogger(AOPTest.class/*"customLogger"*/);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        //ctx.start();

        logger.info("**************");
        for (String name : ctx.getBeanDefinitionNames()) {
            logger.info(name);
        }
        logger.info("**************");


        MyBean mb = ctx.getBean(MyBean.class);
        logger.info(mb.getName());
        mb.testMyBean2();

        //ctx.stop();
    }

}
