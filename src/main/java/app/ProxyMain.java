package app;

import app.service.promotion.MyLogger;
import app.service.promotion.MySecurity;
import app.service.promotion.Promotion;
import app.service.promotion.PromotionA;
import app.service.promotion.PromotionB;
import app.service.promotion.PromotionHandler;
import app.service.promotion.StaticProxyPromotion;
import app.vo.Goods;

public class ProxyMain {

  public static void main(String[] args) throws Exception {
    Goods goods = new Goods();
    goods.setId("asdf");
    goods.setPrice("160");
    Promotion promo = new StaticProxyPromotion(new PromotionA());
//    promo.calcPromotionPrice(goods);
//    System.out.println("static proxy end");
//    System.out.println("-----------------\n");
//    System.out.println("dynamic proxy start");
//    PromotionHandler<Promotion> handler = new PromotionHandler<Promotion>();
//    promo = handler.bind(new PromotionB());
//    promo.calcPromotionPrice(goods);
//    System.out.println("-----------------\n");
//    System.out.println("decorator start");
    promo = new MyLogger(new PromotionA());
    promo = new MySecurity(promo);
    promo.calcPromotionPrice(goods);
  }

}
