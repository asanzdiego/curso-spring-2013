package AroundAdvicewithProceedandchangedargsExample;

public class BusinessLogic implements IBusinessLogic {

  @Override
  public void foo(final int i) {

    System.out.println("Inside BusinessLogic.foo(), passed " + i);
  }
}
