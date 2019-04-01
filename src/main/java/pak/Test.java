package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pak.config.MyConfig;

public class Test {

    private static Logger logger = LoggerFactory.getLogger(Test.class/*"customLogger"*/);


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

        for (String name : ctx.getBeanDefinitionNames()) {
            logger.info(name);
        }



    }

}
