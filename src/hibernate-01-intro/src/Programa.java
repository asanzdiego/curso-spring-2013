import java.util.List;

import model.Persona;
import dao.IPersonaDAO;
import dao.PersonaDAO;

public class Programa {

  public static void main(final String[] args) {

    final IPersonaDAO dao = new PersonaDAO();

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
