package springLoggingAspect;

public class BusinessLogic implements IBusinessLogic {

  @Override
  public void foo() {

    System.out.println("Inside BusinessLogic.foo()");
  }

  @Override
  public void bar() throws BusinessLogicException {

    System.out.println("Inside BusinessLogic.bar()");
    throw new BusinessLogicException();
  }
}
