package AroundAdviceExample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

  @Override
  public Object invoke(final MethodInvocation invocation) throws Throwable {

    System.out.println("Hello world! (by " + this.getClass().getName() + ")");
    return null;
  }
}
