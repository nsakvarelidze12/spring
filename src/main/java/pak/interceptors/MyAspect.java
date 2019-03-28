package pak.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* pak.beans.MyBean.test*(..))")
    public void myPK() {
    }

    //it is advice (before advice)
    @Before("myPK()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        logger.info("additional before concern");
        logger.info("Method Signature: "  + jp.getSignature());
        logger.info("bean name: " + jp.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "execution(* pak.beans.MyBean.get*(..))", returning = "result")
    public void myAfterAdvice(JoinPoint jp, Object result) {
        logger.info("additional after concern");
        logger.info("Method Signature: "  + jp.getSignature());
        logger.info("bean name: " + jp.getTarget().getClass().getName());
        logger.info("returning: " + result.toString());
    }

}
