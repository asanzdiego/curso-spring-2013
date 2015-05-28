import org.aspectj.lang.ProceedingJoinPoint;

public class MiAdvice {

  public Object invoke(final ProceedingJoinPoint joinPoint) throws Throwable {

    final Object[] args = joinPoint.getArgs();

    System.out.println("entrando en " + joinPoint.getSignature().getName()
        + ":" + args[0]);

    args[0] = ((String) args[0]).toUpperCase();

    return joinPoint.proceed(args);
  }

}
