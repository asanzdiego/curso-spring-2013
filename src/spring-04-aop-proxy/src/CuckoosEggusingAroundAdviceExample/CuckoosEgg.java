package CuckoosEggusingAroundAdviceExample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CuckoosEgg implements MethodInterceptor {

  public ReplacementFeature replacementFeature = new ReplacementFeature();

  @Override
  public Object invoke(final MethodInvocation invocation) throws Throwable {

    if (invocation.getMethod().getName().equals("foo")) {
      this.replacementFeature.foo();
    } else {
      this.replacementFeature.bar();
    }

    return null;
  }
}
