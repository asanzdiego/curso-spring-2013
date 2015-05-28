import modelo.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PruebaSave {

  public static void main(final String[] args) {

    save();

  }

  public static void save() {

    final SessionFactory sf = HibernateUtil.getSessionFactory();
    final Session s = sf.openSession();
    s.beginTransaction();

    final Persona p = new Persona(0, "Nombre", "C/Barquillo", 10, 12345);
    final Integer id = (Integer) s.save(p);
    System.out.println("id=" + id);
    p.setNombre("Bender");

    s.getTransaction().commit();
    s.close();
    sf.close();

    PruebaQuery.query();
  }

}
