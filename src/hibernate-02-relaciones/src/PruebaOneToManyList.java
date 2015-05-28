import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.Direccion;
import modelo.Factura;

import org.hibernate.Session;

import util.HibernateUtil;

public class PruebaOneToManyList {

  public static void main(final String[] args) throws InterruptedException {

    final Direccion d = new Direccion("Madrid", "C/Minganillas", "12345");
    final Cliente c = new Cliente(0, "Tubos Borondo", d, "91 123 45 67");

    final List<Factura> facturas = new ArrayList<Factura>();
    facturas.add(new Factura(0, "FAC-1", new Date(), c));
    facturas.add(new Factura(0, "FAC-2", new Date(), c));
    facturas.add(new Factura(0, "FAC-3", new Date(), c));
    facturas.add(new Factura(0, "FAC-4", new Date(), c));
    facturas.add(new Factura(0, "FAC-5", new Date(), c));

    c.setFacturas(facturas);

    System.out.println("==============================");
    Session s = HibernateUtil.getSessionFactory().openSession();
    System.out.println("==============================");

    s.beginTransaction();
    s.saveOrUpdate(c);
    System.out.println("------------------------------");
    s.getTransaction().commit();
    s.close();

    System.out.println("==============================");
    s = HibernateUtil.getSessionFactory().openSession();
    System.out.println("==============================");

    final Cliente c2 = (Cliente) s.get(Cliente.class, 1);
    System.out.println("Nombre:" + c2.getNombre());

    s.close();

    for (final Factura f : c2.getFacturas()) {
      System.out.println(f.getCodigo());
    }

    // s.close();
  }

}
