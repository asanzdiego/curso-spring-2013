package com.mkyong.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class HijackAfterMethod implements AfterReturningAdvice {

  public void afterReturning(final Object returnValue, final Method method,
      final Object[] args, final Object target) throws Throwable {

    System.out.println("HijackAfterMethod : After method hijacked!");
  }
}