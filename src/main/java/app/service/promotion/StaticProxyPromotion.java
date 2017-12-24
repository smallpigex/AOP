package app.service.promotion;

import java.util.logging.Level;
import java.util.logging.Logger;

import app.vo.Goods;

public class StaticProxyPromotion implements Promotion {
  
  private Promotion promo;
  private Logger log = Logger.getLogger(StaticProxyPromotion.class.getName());
  
  public StaticProxyPromotion(Promotion promo) {
    log.setLevel(Level.WARNING);
    this.promo = promo;
  }
  
  @Override
  public String getType() {
    return "static";
  }

  @Override
  public void calcPromotionPrice(Goods goods) throws Exception {
    log.warning("**** static proxy target class: " + promo.getClass());
    log.warning("**** static proxy before");
    log.warning("**** static proxy goods sale price: " + goods.getPrice());
    promo.calcPromotionPrice(goods);
    log.warning("**** static proxy goods promo price: " + goods.getPromoPrice());
    log.warning("**** static proxy after");
  }

  @Override
  public String calcPromotionPrice(String price) {
    // TODO Auto-generated method stub
    return null;
  }

}
