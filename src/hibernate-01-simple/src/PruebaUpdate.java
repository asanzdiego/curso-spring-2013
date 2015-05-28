import modelo.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PruebaUpdate {

  public static void main(final String[] args) {

    update();
  }

  public static void update() {

    PruebaSave.save();

    final SessionFactory sf = HibernateUtil.getSessionFactory();
    final Session s = sf.openSession();
    s.beginTransaction();

    final Persona p = new Persona(1, "NOMBRE ACTUALIZADO", "C/BARQUILLO", 10,
        12345);
    s.update(p);

    s.getTransaction().commit();
    s.close();
    sf.close();

    PruebaQuery.query();
  }

}
