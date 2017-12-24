package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import app.service.promotion.StaticProxyPromotion;
import app.vo.Goods;

@Aspect
public class ApLoggerException {
  private Logger log = Logger.getLogger(ApLoggerException.class.getName());
  
  @Pointcut("execution(* app.service.promotion.Promotion.calcPromotionPrice(..)) "
      + "&& target(app.service.promotion.PromotionException)")
  public void silenceCellPhones() {
  }
  
  @After("silenceCellPhones()")
  public void takeSeats() {
    log.info("@After calcPromotionPrice");
  }

  @AfterReturning("silenceCellPhones()")
  public void applause() {
    log.info("@AfterReturning calcPromotionPrice");
  }

  @AfterThrowing("silenceCellPhones()")
  public void demandRefund() {
    log.info("@AfterThrowing calcPromotionPrice Exception");
  }

}
