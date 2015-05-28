import modelo.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PruebaDetached {

  public static void main(final String[] args) {

    PruebaSave.save(); // salvamos p1
    PruebaSave.save(); // salvamos p2

    final SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s = sf.openSession();

    s.beginTransaction();
    final Persona p1 = (Persona) s.get(Persona.class, 1);
    Persona p2 = (Persona) s.get(Persona.class, 2);
    p1.setNombre("Ringo");
    System.out.println("p1=" + p1);
    s.evict(p1);
    s.getTransaction().commit();
    s.close();

    PruebaQuery.query();

    // Otra session
    s = sf.openSession();
    s.beginTransaction();
    p2.setNombre("FRY");
    System.out.println("p2=" + p2);
    p2 = (Persona) s.merge(p2);
    System.out.println("p2=" + p2);
    p2.setDireccion("Atriquitraun");
    s.getTransaction().commit();
    sf.close();

    PruebaQuery.query();

  }

}
