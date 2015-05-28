package com.miempresa.ejemplo.aop.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Advice implements MethodInterceptor {

	@Override
	public Object invoke(final MethodInvocation mi) throws Throwable {

		System.out.println("entrando en " + mi.getMethod().getName()
				+ " con los argumentos " + mi.getArguments()[0]);

		if (mi.getArguments()[0] instanceof String) {

			mi.getArguments()[0] = (mi.getArguments()[0]).toString()
					.toUpperCase();
		}

		return mi.proceed();
	}
}
