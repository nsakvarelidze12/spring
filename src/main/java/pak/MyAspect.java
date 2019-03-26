package pak;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* MyBean.test*(..))")
    public void myPK() {
    }

    //it is advice (before advice)
    @Before("myPK()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        logger.info("additional before concern");
        logger.info("Method Signature: "  + jp.getSignature());
    }

    @AfterReturning(pointcut = "execution(* MyBean.get*(..))", returning= "result")
    public void myAfterAdvice(Object result) {
        logger.info("additional after concern");
        logger.info(result.toString());
    }

}
