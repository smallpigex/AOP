package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import app.service.promotion.StaticProxyPromotion;

@Aspect
public class ApLogger {
  private Logger log = Logger.getLogger(ApLogger.class.getName());
  
  @Before("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void silenceCellPhones() {
    log.info("@Before calcPromotionPrice");
  }
  
  @After("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void takeSeats() {
    log.info("@After calcPromotionPrice");
  }

  @AfterReturning("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void applause() {
    log.info("@AfterReturning calcPromotionPrice");
  }

  @AfterThrowing("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void demandRefund() {
    log.info("@AfterThrowing calcPromotionPrice");
  }

}
