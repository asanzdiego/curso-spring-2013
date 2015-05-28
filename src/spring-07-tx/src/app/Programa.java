package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

  public static void main(final String[] args) {

    final String configFile = "spring-3.xml";

    final ApplicationContext appCtx = new ClassPathXmlApplicationContext(
        configFile);

    final Service s = (Service) appCtx.getBean("miServicio");

    try {

      s.save(appCtx);
      s.savePersonas(appCtx);

    } catch (final Exception e) {
      e.printStackTrace();
    }

  }
}
