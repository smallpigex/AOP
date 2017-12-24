package app.service.promotion;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.vo.Goods;

@Service
public class PromotionA implements Promotion {
  private Logger log = Logger.getLogger(PromotionA.class.getName());

  @Override
  public Goods calcPromotionPrice(Goods goods) {
   
    goods.setPromoPrice(calcPromotionPrice(goods.getPrice()));
    ObjectMapper mapper = new ObjectMapper();
    try {
      System.out.println("       |--- Class:" + this.getClass());
      System.out.println("       |--- PromotionA Goods info:" + mapper.writeValueAsString(goods));
    } catch (JsonProcessingException e) {
      log.log(Level.WARNING, e.getMessage());
    }
    return goods;
  }

  @Override
  public String getType() {
    return "A";
  }

  @Override
  public String calcPromotionPrice(String price) {
    BigDecimal decimal = BigDecimal.valueOf(Long.valueOf(price));
    return decimal.multiply(BigDecimal.valueOf(0.9)).toString();
  }

}
