package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ApLoggerAround {
  private Logger log = Logger.getLogger(ApLoggerAround.class.getName());
  
  @Around("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void calc(ProceedingJoinPoint pjp) {
    log.info("before");
    try {
      pjp.proceed();
    } catch (Throwable e) {
      log.info("exception : " + e.getMessage());
    }
    log.info("after");
  }
}
