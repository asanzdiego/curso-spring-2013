import modelo.Cliente;
import modelo.Direccion;

import org.hibernate.Session;

import util.HibernateUtil;

public class PruebaComponent {

  public static void main(final String[] args) {

    final Direccion d = new Direccion("Salamanca", "Horno 2", "12345");
    final Cliente c = new Cliente(0, "Pipas Facundo", d, "923 23 45 67");

    final Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();

    s.save(c);

    s.getTransaction().commit();
    s.close();

    System.out.println(c);
  }

}
