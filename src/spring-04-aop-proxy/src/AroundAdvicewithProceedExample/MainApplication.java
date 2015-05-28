package AroundAdvicewithProceedExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApplication {

  public static void main(final String[] args) {

    // Read the configuration file
    final ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "src/AroundAdvicewithProceedExample/springconfig.xml");

    // Instantiate an object
    final IBusinessLogic testObject = (IBusinessLogic) ctx
        .getBean("businesslogicbean");

    // Execute the public method of the bean (the test)
    testObject.foo();
  }
}
