package AroundAdvicewithProceedandchangedargsExample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

  @Override
  public Object invoke(final MethodInvocation invocation) throws Throwable {

    System.out.println("Hello world! (by " + this.getClass().getName() + ")");

    System.out.println("First argument is: "
        + invocation.getArguments()[0].getClass());

    invocation.getArguments()[0] = new Integer(20);

    invocation.proceed();

    System.out.println("Goodbye! (by " + this.getClass().getName() + ")");

    return null;
  }
}
