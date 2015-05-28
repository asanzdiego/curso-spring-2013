import model.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Detached {

  public static void main(final String[] args) {

    final SessionFactory sf = new Configuration().configure(
        "model/hibernate.cfg.xml").buildSessionFactory();

    Session session = sf.openSession();

    final Persona p1 = new Persona();
    p1.setNombre("transient");
    p1.setEdad(1);
    System.out.println(p1);

    p1.setNombre("persistent");
    final Integer id1 = (Integer) session.save(p1); // el objeto pasa de
                                                    // transient a persistent
    System.out.println("p1=" + p1);

    p1.setNombre("modificado pero todavía no guardado");
    System.out.println("p1=" + p1);

    session.refresh(p1); // recarga el objeto de base de datos
    System.out.println("p1=" + p1);

    session.evict(p1); // el objeto pasa a detached
    p1.setNombre("detached");
    System.out.println("p1=" + p1);

    session.close();
    System.out.println("sesion cerrada");

    session = sf.openSession();
    session.beginTransaction();

    final Persona p2 = (Persona) session.get(Persona.class, id1);
    System.out.println("p2=" + p2);

    final Persona p3 = (Persona) session.merge(p1); // devuelve un objeto
                                                    // persistente
    System.out.println("p3=" + p3);

    p3.setNombre("estos cambios tendrán efectos");
    p1.setNombre("estos cambios NO tendrán efectos");

    session.getTransaction().commit(); // si es un objeto persistene, en una
                                       // transaccion no hace falta llamar al
                                       // método save
    session.close();
    System.out.println("sesion cerrada");

    session = sf.openSession();
    final Persona p4 = (Persona) session.get(Persona.class, id1);
    System.out.println("p4=" + p4);
  }
}
