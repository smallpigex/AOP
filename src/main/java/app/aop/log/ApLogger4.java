package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ApLogger4 {
  private Logger log = Logger.getLogger(ApLogger4.class.getName());
  
  @Before("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void before(JoinPoint jp) {
    log.info("JoinPoint class: " + jp.getClass());
    log.info("JoinPoint Signature class: " + jp.getSignature().getClass());
    log.info("JoinPoint Signature method: " + jp.getSignature().getName());
  }

}
