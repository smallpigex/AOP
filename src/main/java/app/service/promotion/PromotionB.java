package app.service.promotion;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.vo.Goods;

@Service
public class PromotionB implements Promotion {
  private Logger log = Logger.getLogger(PromotionA.class.getName());
  
  @Override
  public void calcPromotionPrice(Goods goods) {
    BigDecimal decimal =BigDecimal.valueOf(Long.valueOf(goods.getPrice()));
    
    goods.setPromoPrice(decimal.subtract(BigDecimal.valueOf(50)).toString());
    
    ObjectMapper mapper = new ObjectMapper();
    try {
      System.out.println("          |--- Class:" + this.getClass());
      System.out.println("          |--- PromotionA Goods info:" + mapper.writeValueAsString(goods));
    } catch (JsonProcessingException e) {
      log.log(Level.WARNING, e.getMessage());
    }
  }

  @Override
  public String getType() {
    return "B";
  }

  @Override
  public String calcPromotionPrice(String price) {
    return null;
  }

}
