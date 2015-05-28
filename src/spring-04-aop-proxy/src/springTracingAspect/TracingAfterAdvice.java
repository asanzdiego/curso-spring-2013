package springTracingAspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class TracingAfterAdvice implements AfterReturningAdvice {

  @Override
  public void afterReturning(final Object object, final Method m,
      final Object[] args, final Object target) throws Throwable {

    System.out.println("Hello world! (by " + this.getClass().getName() + ")");
  }
}
