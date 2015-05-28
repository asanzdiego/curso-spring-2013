package com.mkyong.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HijackAroundMethod implements MethodInterceptor {

  public Object invoke(final MethodInvocation methodInvocation)
      throws Throwable {

    System.out.println("Method name : "
        + methodInvocation.getMethod().getName());
    System.out.println("Method arguments : "
        + Arrays.toString(methodInvocation.getArguments()));

    // same with MethodBeforeAdvice
    System.out.println("HijackAroundMethod : Before method hijacked!");

    try {
      // proceed to original method call
      final Object result = methodInvocation.proceed();

      // same with AfterReturningAdvice
      System.out.println("HijackAroundMethod : Before after hijacked!");

      return result;

    } catch (final IllegalArgumentException e) {
      // same with ThrowsAdvice
      System.out.println("HijackAroundMethod : Throw exception hijacked!");
      throw e;
    }
  }
}