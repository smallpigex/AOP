package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.aop.log.ApLoggerReturn;

@Configuration
@EnableAspectJAutoProxy//(proxyTargetClass=true)
@ComponentScan
public class AopConfig {
  
//  @Bean
//  public ApLogger apLogger() {
//    return new ApLogger();
//  }
  
//  @Bean
//  public ApLogger2 apLogger2() {
//    return new ApLogger2();
//  }
  
//  @Bean
//  public ApLogger3 apLogger3() {
//    return new ApLogger3();
//  }
  
//  @Bean
//  public ApLogger4 apLogger4() {
//    return new ApLogger4();
//  }
//  
//  @Bean
//  public ApLoggerException apLoggerException() {
//    return new ApLoggerException();
//  }
  
  @Bean
  public ApLoggerReturn apLoggerReturn() {
    return new ApLoggerReturn();
  }
  
//  @Bean
//  public ApLoggerAround apLoggerAround() {
//    return new ApLoggerAround();
//  }
}
