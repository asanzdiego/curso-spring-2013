package springLoggingAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApplication {

  public static void main(final String[] args) {

    // Read the configuration file
    final ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "src/springLoggingAspect/springconfig.xml");

    // Instantiate an object
    final IBusinessLogic testObject = (IBusinessLogic) ctx
        .getBean("businesslogicbean");

    // Execute the public methods of the bean
    testObject.foo();

    try {
      testObject.bar();
    } catch (final BusinessLogicException ble) {
      System.out.println("Caught BusinessLogicException");
    }
  }
}
