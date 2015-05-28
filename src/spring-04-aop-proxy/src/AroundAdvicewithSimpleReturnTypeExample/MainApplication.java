package AroundAdvicewithSimpleReturnTypeExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApplication {

  public static void main(final String[] args) {

    // Read the configuration file
    final ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "src/AroundAdvicewithSimpleReturnTypeExample/springconfig.xml");

    // Instantiate an object
    final IBusinessLogic testObject = (IBusinessLogic) ctx
        .getBean("businesslogicbean");

    // Execute the public method of the bean (the test)
    final int fooReturnValue = testObject.foo();
    System.out.println("Return value from test object: " + fooReturnValue);
  }
}
