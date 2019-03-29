package pak.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* pak.aop.MyBean3.get*(..))")
    public void myPK() {
    }

    //it is advice (before advice)
    @Before("myPK()") //applying pointcut on advice
    public void myBeforeAdvice(JoinPoint jp) {
        logger.info("before");
        logger.info("Method Signature: "  + jp.getSignature());
        logger.info("bean name: " + jp.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "execution(* pak.aop.MyBean3.get*(..))", returning = "result")
    public void myAfterAdvice(JoinPoint jp, Object result) {
        logger.info("after returning");
        logger.info("Method Signature: "  + jp.getSignature());
        logger.info("bean name: " + jp.getTarget().getClass().getName());
        logger.info("returns: " + result.toString());
    }

}
