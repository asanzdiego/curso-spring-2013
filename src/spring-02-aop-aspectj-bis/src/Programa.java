import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Programa {

  public static void main(final String[] args) {

    final ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "src/aop.xml");
    final Persona p = (Persona) ctx.getBean("persona");
    p.setNombre("pepe");
    System.out.println(p);
  }
}
