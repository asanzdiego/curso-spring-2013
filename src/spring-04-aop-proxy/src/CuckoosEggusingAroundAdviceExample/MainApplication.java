package CuckoosEggusingAroundAdviceExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApplication {

  public static void main(final String[] args) {

    // Read the configuration file
    final ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "src/CuckoosEggusingAroundAdviceExample/springconfig.xml");

    // Instantiate an object
    final IBusinessLogic testObject = (IBusinessLogic) ctx
        .getBean("businesslogicbean");
    final IBusinessLogic2 testObject2 = (IBusinessLogic2) ctx
        .getBean("businesslogicbean2");

    // Execute the public method of the beans (the test)
    testObject.foo();
    testObject2.bar();
    testObject2.baz();
  }
}
