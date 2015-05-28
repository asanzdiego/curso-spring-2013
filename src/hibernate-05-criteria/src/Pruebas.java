import java.util.List;

import modelo.Cliente;
import modelo.Producto;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibUtil;

public class Pruebas {

  public static void main(final String[] args) {

    final Session s = HibUtil.getSessionFactory().openSession();

    final Criteria c1 = s.createCriteria(Cliente.class)
        .add(Restrictions.like("nombre", "A%"))
        .add(Restrictions.eq("direccion.ciudad", "Salamanca"));

    final Criteria c2 = s.createCriteria(Producto.class).add(
        Restrictions.between("stock", 1, 100));

    final Criteria c3 = s.createCriteria(Cliente.class).add(
        Restrictions.or(Restrictions.eq("direccion.ciudad", "Salamanca"),
            Restrictions.eq("direccion.ciudad", "Chinchon")));

    final Criteria c4 = s.createCriteria(Cliente.class).add(
        Restrictions.in("direccion.ciudad", new String[] { "Salamanca",
            "Chinchon", "Pitiegia" }));

    // Order by
    final Criteria c5 = s
        .createCriteria(Cliente.class)
        .add(
            Restrictions.in("direccion.ciudad", new String[] { "Salamanca",
                "Chinchon", "Pitiegia" })).addOrder(Order.asc("nombre"));

    // ASOCIACIONES
    final Criteria c6 = s.createCriteria(Cliente.class)
        .add(Restrictions.eq("direccion.ciudad", "Madrid"))
        .createCriteria("facturas").add(Restrictions.gt("fecha", "2008/10/10"));

    // FECTH
    final Criteria c7 = s.createCriteria(Cliente.class)
        .add(Restrictions.eq("direccion.ciudad", "Madrid"))
        .createCriteria("facturas").add(Restrictions.gt("fecha", "2008/10/10"))
        .setFetchMode("facturas", FetchMode.EAGER);

    final List<Cliente> rs1 = c1.list();
    for (final Cliente c : rs1) {
      System.out.println(c.getNombre());
    }

    s.close();

  }

}
