package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.service.promotion.Promotion;
import app.service.promotion.PromotionA;
import app.service.promotion.PromotionB;
import app.service.promotion.PromotionRouter;
import app.vo.Goods;

@Service
public class PromotionSvc {
  @Autowired 
  PromotionRouter promotionRouter;
  @Autowired
  Goods goods;
  public String getPromPrice(String promoType, String goodsId) throws Exception {
    
    goods.setId(goodsId);
    goods.setPrice("100");
    
    Promotion promo = promotionRouter.getPromotion(promoType);
    System.out.println("**PromotionSvc call promo.calcPromotionPrice(g) **");
    promo.calcPromotionPrice(goods);
    System.out.println("**PromotionSvc after return promo.calcPromotionPrice(g)**");
    String promoPrice = goods.getPromoPrice();
    return promoPrice;
  }
  
  private Promotion createPromotion(String promoType) {
    if("A".equals(promoType)) {
      return new PromotionA();
    } else {
      return new PromotionB();
    }
  }
  
}
