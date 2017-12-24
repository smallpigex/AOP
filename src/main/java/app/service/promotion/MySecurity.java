package app.service.promotion;

import app.vo.Goods;

public class MySecurity implements PromotionDecorator {
  
  Promotion promo;
  public MySecurity(Promotion promo) {
    this.promo = promo;
  }
  @Override
  public String getType() {
    return null;
  }

  @Override
  public void calcPromotionPrice(Goods goods) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("Security");
    promo.calcPromotionPrice(goods);
  }

  @Override
  public String calcPromotionPrice(String price) {
    // TODO Auto-generated method stub
    return null;
  }

}
