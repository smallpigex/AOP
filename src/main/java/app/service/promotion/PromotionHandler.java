package app.service.promotion;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromotionHandler<T> implements InvocationHandler {


  private Logger logger = Logger.getLogger(this.getClass().getName());

  private T delegate;
  @SuppressWarnings("unchecked")
  public T bind(T delegate) {
    this.delegate = delegate;
    return (T) Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
        delegate.getClass().getInterfaces(), this);
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;
    try {
      log("**** dynamic proxy target class: " + proxy.getClass());
      log("**** dynamic proxy before");
      log("**** dynamic proxy goods sale price:");
      result = method.invoke(delegate, args);
      log("dynamic proxy class end..." + method);
    } catch (Exception e) {
      log(e.toString());
    }

    return result;
  }

  private void log(String message) {
    logger.log(Level.INFO, message);
  }

}
