package app.service.promotion;

import org.springframework.stereotype.Service;

import app.vo.Goods;

@Service
public class PromotionException implements Promotion {

  @Override
  public String getType() {
    return "exception";
  }

  @Override
  public void calcPromotionPrice(Goods goods) throws Exception {
      throw new Exception("Promotion exception");
  }

  @Override
  public String calcPromotionPrice(String price) {
    // TODO Auto-generated method stub
    return null;
  }

}
