package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import app.vo.Goods;

@Aspect
public class ApLogger3 {
  private Logger log = Logger.getLogger(ApLogger3.class.getName());
  //
  @Pointcut("execution(* app.service.promotion.Promotion.calcPromotionPrice(app.vo.Goods)) && args(goods)"
      + " target(app.service.promotion.PromotionA) && !target(app.service.promotion.PromotionA)")
  public void calc(Goods goods) {
    log.info("Call pointcut " + this.getClass().getName() + "-----");
  }
  
  @Before("calc(goods)")
  public void before(Goods goods) {
    
    log.info("@Pointcut @Before calcPromotionPrice " + goods.getPrice());
    log.info("AspectJ: " + this.getClass());
  }
  
  @AfterReturning("calc(goods)")
  public void afterReturn(Goods goods) {
//    goods.setPrice(price);
    log.info("@Pointcut @AfterReturning calcPromotionPrice " + goods.getPromoPrice() );
  }

}
