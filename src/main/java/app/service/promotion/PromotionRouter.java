package app.service.promotion;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;

@Component
public class PromotionRouter implements InitializingBean{

  private static final Map<String, Promotion> routerMap = Maps.newHashMap();

  @Autowired
  private List<Promotion> promotionList;

  @Override
  public void afterPropertiesSet() throws Exception {
      for (Promotion promotion : promotionList) {
          routerMap.put(promotion.getType(), promotion);
      }
  }

  public Promotion getPromotion(String type) {
      return routerMap.get(type);
  }

}
