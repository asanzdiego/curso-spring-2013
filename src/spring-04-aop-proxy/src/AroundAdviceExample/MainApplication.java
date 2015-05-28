package AroundAdviceExample;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApplication
{
   public static void main(String [] args)
   {
      // Read the configuration file
      ApplicationContext ctx
          = new FileSystemXmlApplicationContext("src/AroundAdviceExample/springconfig.xml");

      //Instantiate an object
      IBusinessLogic testObject = (IBusinessLogic) ctx.getBean("businesslogicbean");

      //Execute the public method of the bean (the test)
      testObject.foo();
   }
}
