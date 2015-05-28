package AroundAdvicewithSimpleReturnTypeExample;

public class BusinessLogic implements IBusinessLogic {

  @Override
  public int foo() {

    System.out.println("Inside BusinessLogic.foo()");
    return 10;
  }
}
