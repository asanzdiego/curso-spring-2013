import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import modelo.Cliente;
import modelo.Direccion;
import modelo.Pedido;

import org.hibernate.Session;

import util.HibernateUtil;

public class PruebaOneToMany {

  public static void main(final String[] args) throws InterruptedException {

    System.out.println("==============================");
    final Direccion d = new Direccion("Madrid", "C/Barquillo", "12345");
    final Cliente c = new Cliente(0, "Iberica de Molinillos", d, "91 123 45 67");

    final Set<Pedido> pedidos = new HashSet<Pedido>();
    pedidos.add(new Pedido(0, "COD-1", new Date(), c));
    pedidos.add(new Pedido(0, "COD-2", new Date(), c));
    pedidos.add(new Pedido(0, "COD-3", new Date(), c));
    pedidos.add(new Pedido(0, "COD-4", new Date(), c));
    pedidos.add(new Pedido(0, "COD-5", new Date(), c));

    c.setPedidos(pedidos);

    Session s = HibernateUtil.getSessionFactory().openSession();
    s.beginTransaction();

    s.saveOrUpdate(c);

    s.getTransaction().commit();
    s.close();

    s = HibernateUtil.getSessionFactory().openSession();

    System.out.println("==============================");
    final Cliente c2 = (Cliente) s.get(Cliente.class, 1);

    System.out.println("Nombre:" + c2.getNombre());

    // s.close();

    for (final Pedido p : c2.getPedidos()) {
      System.out.println(p.getCodigo());
    }

    s.close();
  }

}
