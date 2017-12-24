package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.service.PromotionSvc;

@RestController
public class PromotionController {
  @Autowired 
  PromotionSvc promoSvc;
  
  @RequestMapping(value = "/promo/{type}/goods/{id}", method = RequestMethod.GET)
  @ResponseBody
  public String getPromoPrice(
      @PathVariable("type") String promoType,
      @PathVariable("id") String id) throws Exception {
    
    return promoSvc.getPromPrice(promoType, id);
  }
}
