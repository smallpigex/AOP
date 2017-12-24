package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.AopConfig;
import app.service.promotion.Promotion;
import app.service.promotion.PromotionA;
import app.service.promotion.PromotionRouter;
import app.vo.Goods;

public class Main {

  public static void main(String[] args) throws Exception {
    String type = "A";
    ApplicationContext ctx = new AnnotationConfigApplicationContext(new String[] {"app.aop.log", "app.config", "app.service.promotion"});
    //ctx.scan("app.config");
    PromotionRouter router = ctx.getBean(PromotionRouter.class);
    Goods goods = new Goods();
    goods.setId("1");
    goods.setPrice("200");
    router.getPromotion(type).calcPromotionPrice(goods);
//    router.getPromotion(type).calcPromotionPrice("100");
    System.out.println("PromotionA class is " + goods.getPromoPrice());
    
  }

}
