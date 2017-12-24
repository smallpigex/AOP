package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.vo.Goods;

@Configuration
public class AppConfig {

  @Bean
  public Goods goods() {
    return new Goods();
  }
}
