package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import app.vo.Goods;

@Aspect
public class ApLoggerReturn {
  private Logger log = Logger.getLogger(ApLoggerReturn.class.getName());
  
  @AfterReturning(
      pointcut="execution(* app.service.promotion.PromotionA.calcPromotionPrice(..))", 
      returning="returnValue")
  public void afterReturn(JoinPoint jp, Goods returnValue) {
    returnValue.setPromoPrice("1000");
    log.info("@Pointcut @AfterReturning calcPromotionPrice return value is " + returnValue.getPromoPrice());
  }

}
