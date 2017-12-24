package app.aop.log;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ApLogger2 {
  private Logger log = Logger.getLogger(ApLogger2.class.getName());
  
  
//  @Before("calc()")
  @Pointcut("execution(* app.service.promotion.Promotion.calcPromotionPrice(..))")
  public void calc() {
    System.out.println("Call pointcut");
  }
  
  @Before("calc()")
  public void before() {
    log.info("@Pointcut @Before calcPromotionPrice");
  }
  
  @After("calc()")
  public void after() {
    log.info("@Pointcut @After calcPromotionPrice");
  }

  @AfterReturning("calc()")
  public void afterReturn() {
    log.info("@Pointcut @AfterReturning calcPromotionPrice");
  }

  @AfterThrowing("calc()")
  public void afterThrowing() {
    log.info("@Pointcut @AfterThrowing calcPromotionPrice");
  }

}
