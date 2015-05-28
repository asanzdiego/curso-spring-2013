package CuckoosEggusingAroundAdviceExample;

public class BusinessLogic implements IBusinessLogic {

  // In this example, foo is part of the overall component role that is being
  // replaced
  @Override
  public void foo() {

    System.out.println("Inside BusinessLogic.foo()");
  }
}