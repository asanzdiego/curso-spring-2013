import java.util.List;

import modelo.Persona;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PruebaQuery {

  public static void main(final String[] args) {

    query();
  }

  public static void query() {

    final SessionFactory sf = HibernateUtil.getSessionFactory();

    final Session s = sf.openSession();
    s.beginTransaction();

    final Query q = s.createQuery("select p from Persona p");
    final List<Persona> lista = q.list();

    for (final Persona p : lista) {
      System.out.println(p);
    }

    s.getTransaction().commit();
    s.close();
    sf.close();
  }
}
