import modelo.Cliente;
import modelo.DatosBancarios;
import modelo.Direccion;

import org.hibernate.Session;

import util.HibernateUtil;

public class PruebaOneToOne {

  public static void main(final String[] args) {

    final Direccion d = new Direccion("Madrid", "C/Alcala", "12345");
    final Cliente c = new Cliente(0, "Hierros del Norte", d, "91 123 45 67");

    final DatosBancarios db = new DatosBancarios(0, c, "HTC", 5000);
    c.setDatosBancarios(db);

    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();

    s.save(c);

    s.getTransaction().commit();
    s.close();

    s = HibernateUtil.getSessionFactory().openSession();

    System.out.println("==============================");
    final Cliente c2 = (Cliente) s.get(Cliente.class, 1);

    System.out.println("Nombre:" + c2.getNombre());
    System.out.println("Banco:" + c2.getDatosBancarios().getBanco());

    s.close();

  }

}
