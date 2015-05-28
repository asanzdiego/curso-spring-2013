import java.util.HashSet;
import java.util.Set;

import modelo.Cliente;
import modelo.Comercial;
import modelo.Direccion;

import org.hibernate.Session;

import util.HibernateUtil;

public class PruebasManyToMany {

  public static void main(final String[] args) {

    final Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();

    final Cliente cl1 = new Cliente(null, "CLI-1", new Direccion(), null);
    final Cliente cl2 = new Cliente(null, "CLI-2", new Direccion(), null);

    final Comercial co1 = new Comercial(null, "COM-1", null);
    final Comercial co2 = new Comercial(null, "COM-2", null);
    final Comercial co3 = new Comercial(null, "COM-3", null);

    final Set<Comercial> comerciales1 = new HashSet<Comercial>();
    comerciales1.add(co1);
    comerciales1.add(co2);

    final Set<Comercial> comerciales2 = new HashSet<Comercial>();
    comerciales2.add(co2);
    comerciales2.add(co3);

    cl1.setComerciales(comerciales1);
    cl2.setComerciales(comerciales2);

    s.save(cl1);
    s.save(cl2);

    s.getTransaction().commit();
    s.close();

  }

}
