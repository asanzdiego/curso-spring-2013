import modelo.Consultoria;
import modelo.Hardware;
import modelo.Producto;
import modelo.Software;

import org.hibernate.Session;

import util.HibernateUtil;

public class Pruebas {

  public static void main(final String[] args) {

    final Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();

    final Producto p = new Producto(0, "ProductoGenerico", 0);
    final Software sw = new Software(0, "WEB", 20000, "JSF+Hib");
    final Hardware hw = new Hardware(0, "PC", 1000, 15);
    final Consultoria c = new Consultoria(0, "XXX", 50, 400);

    s.save(p);
    s.save(sw);
    s.save(hw);
    s.save(c);

    s.getTransaction().commit();
    s.close();

  }

}
