package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Hello {

    private static Logger logger = LoggerFactory.getLogger(Hello.class/*"customLogger"*/);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        //ctx.start();

        MyBean mb1 = ctx.getBean(MyBean.class);
        logger.info(mb1.getName());
        mb1.testMyBean2();

        //ctx.stop();
    }

}
