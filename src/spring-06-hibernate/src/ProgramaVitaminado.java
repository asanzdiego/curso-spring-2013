import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaVitaminado {

  public static void main(final String[] args) {

    final ApplicationContext appCtx = new ClassPathXmlApplicationContext(
        "spring.xml");
    final IPersonaDAO dao = (IPersonaDAO) appCtx.getBean("miDao");

    final Persona p = new Persona();
    p.setEdad(5);
    p.setNombre("fer");

    dao.save(p);

    final List<Persona> lista = dao.list();
    for (final Persona persona : lista) {
      System.out.println(persona);
    }

    System.out.println("numero de personas = " + lista.size());
  }
}
