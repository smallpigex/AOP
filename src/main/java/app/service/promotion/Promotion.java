package app.service.promotion;

import org.springframework.stereotype.Service;

import app.vo.Goods;
@Service
public interface Promotion {
  public String getType();
  public Goods calcPromotionPrice(Goods goods) throws Exception;
  public String calcPromotionPrice(String price);
}
