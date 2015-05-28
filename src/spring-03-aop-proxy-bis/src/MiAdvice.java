import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MiAdvice implements MethodInterceptor {

  @Override
  public Object invoke(final MethodInvocation mi) throws Throwable {

    System.out.println("entrando en " + mi.getMethod().getName() + ":"
        + mi.getArguments()[0]);

    mi.getArguments()[0] = ((String) mi.getArguments()[0]).toUpperCase();

    return mi.proceed();
  }

}
