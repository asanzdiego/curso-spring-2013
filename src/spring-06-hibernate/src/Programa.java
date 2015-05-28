import java.util.List;

public class Programa {

  public static void main(final String[] args) {

    final IPersonaDAO dao = new PersonaDAO();
    final List<Persona> lista = dao.list();
    for (final Persona persona : lista) {
      System.out.println(persona);
    }
  }

}
