package asanzdiego.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Advice implements MethodInterceptor {

	public Object invoke(final MethodInvocation mi) throws Throwable {

		final Object[] args = mi.getArguments();

		final Object target = mi.getThis();

		if (target instanceof Pet) {

			final Integer edad = (Integer) args[0];

			System.out.println("is a pet");

			if (edad.intValue() > 2) {
				System.out.println("age is greater than 2");
				args[0] = 2;
			}
		}

		if (target instanceof Person) {

			final Integer edad = (Integer) args[0];

			System.out.println("is a person");

			if (edad.intValue() < 18) {
				System.out.println("age is less than 18");
				args[0] = 18;
			}
		}

		return mi.proceed();
	}
}