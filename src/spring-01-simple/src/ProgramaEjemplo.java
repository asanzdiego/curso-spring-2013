import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaEjemplo {

  public static void main(final String[] args) {

    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
    new String[] { "mispojos.xml", "masbeans.xml" });

    final Persona p1 = (Persona) ctx.getBean("miPersona");
    final Persona p2 = (Persona) ctx.getBean("miPersona");
    final Persona p3 = (Persona) ctx.getBean("miPersona2");
    final Persona p4 = (Persona) ctx.getBean("miPersona2");
    final Persona p5 = (Persona) ctx.getBean("esaPersona");
    final Persona p6 = (Persona) ctx.getBean("aquellaPersona");
    final Persona p7 = (Persona) ctx.getBean("aquellaOtraPersona");
    final PersonaDao dao = (PersonaDao) ctx.getBean("miDao");
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
    System.out.println(p4);
    System.out.println(p5);
    System.out.println(p6);
    System.out.println(p7);
    System.out.println(dao);
    ctx.close();
  }
}

