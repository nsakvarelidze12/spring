package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pak.aop.MyBean;
import pak.aop.MyBean2;
import pak.aop.MyBean3;
import pak.config.ConfigAop;

public class AOPTest {

    private static Logger logger = LoggerFactory.getLogger(AOPTest.class/*"customLogger"*/);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigAop.class);
        //ctx.start();

        logger.info("**************");
        for (String name : ctx.getBeanDefinitionNames()) {
            logger.info(name);
        }
        logger.info("**************");

        MyBean mb = ctx.getBean(MyBean.class);
        mb.printName();
        mb.callOtherBean();

        MyBean2 mb2 = ctx.getBean(MyBean2.class);
        mb2.printName();
        mb2.callOtherBean();

        MyBean3 mb3 = ctx.getBean(MyBean3.class);
        mb3.printName();
        mb3.getName();

        //ctx.stop();
    }

}
