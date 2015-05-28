package springLoggingAspect;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LoggingThrowsAdvice implements ThrowsAdvice {

  public void afterThrowing(final Method method, final Object[] args,
      final Object target, final Throwable subclass) {

    System.out.println("Logging that a " + subclass + "Exception was thrown.");
  }
}
