package springLoggingAspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class TracingBeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(final Method m, final Object[] args, final Object target)
      throws Throwable {

    System.out.println("Hello world! (by " + this.getClass().getName() + ")");
  }
}