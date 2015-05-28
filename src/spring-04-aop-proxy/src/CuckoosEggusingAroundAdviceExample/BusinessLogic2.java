package CuckoosEggusingAroundAdviceExample;

public class BusinessLogic2 implements IBusinessLogic2 {

  // In this example, bar is a part of the overall component role that is being
  // replaced
  @Override
  public void bar() {

    System.out.println("Inside BusinessLogic2.bar()");
  }

  // In this example, bax is not part of the overall component role that is
  // being replaced
  @Override
  public void baz() {

    System.out.println("Inside BusinessLogic2.baz()");
  }
}
