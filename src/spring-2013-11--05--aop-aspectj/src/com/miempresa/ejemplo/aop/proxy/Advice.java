package com.miempresa.ejemplo.aop.proxy;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {

	public Object invoke(final ProceedingJoinPoint joinPoint) throws Throwable {

		final Object[] args = joinPoint.getArgs();

		System.out.println("entrando en " + joinPoint.getSignature().getName()
				+ " con los argumentos " + args[0]);

		if (args[0] instanceof String) {
			args[0] = ((String) args[0]).toUpperCase();
		}

		return joinPoint.proceed(args);
	}

}
