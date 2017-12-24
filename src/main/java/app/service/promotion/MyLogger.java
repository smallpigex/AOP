package app.service.promotion;

import java.util.logging.Logger;

import app.vo.Goods;

public class MyLogger implements PromotionDecorator {
  private Promotion promo;
  
  private Logger log = Logger.getLogger(MyLogger.class.getName());
  
  public MyLogger(Promotion promo) {
    this.promo = promo;
  }
  @Override
  public String getType() {
    return "log";
  }

  @Override
  public void calcPromotionPrice(Goods goods) throws Exception {
    log.info("Promotion Decorator log price " + goods.getPrice());
    promo.calcPromotionPrice(goods);
    log.info("Promotion Decorator log promo price " + goods.getPromoPrice());
  }

  @Override
  public String calcPromotionPrice(String price) {
    // TODO Auto-generated method stub
    return null;
  }

}
