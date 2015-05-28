import java.util.List;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import modelo.ResumenCliente;
import modelo.Software;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

public class PruebasHQL {

  public static void main(final String[] args) {

    final Session s = HibernateUtil.getSessionFactory().openSession();

    System.out.println("=====================");
    final Query q1 = s.createQuery("select c from modelo.Cliente as c");
    // Autoimport
    // no hace falta poner el 'as'
    final Query q2 = s.createQuery("select c from Cliente c");
    // Si es 'select *' nos ahorramos el select
    final Query q2Bis = s.createQuery("from Cliente c");
    final List<Cliente> rs1 = q2Bis.list();
    for (final Cliente c : rs1) {
      System.out.println(c.getNombre());
    }

    System.out.println("=====================");
    // Producto cartesiano:
    final Query q3 = s.createQuery("from Cliente c, Pedido p");

    // JOIN IMPLICITO
    final Query q4 = s
        .createQuery("from Pedido p where p.cliente.direccion.ciudad='Barcelona'");
    final List<Pedido> rs4 = q4.list();
    for (final Pedido p : rs4) {
      System.out.println(p.getCodigo());
      System.out.println(p.getCliente().getNombre());
    }

    System.out.println("=====================");
    // Obtener atributos sueltos:
    // Por defecto devuelve array
    final Query q5 = s
        .createQuery("select c.nombre, c.telefono from Cliente c");
    final List<Object[]> rs5 = q5.list();
    for (final Object[] arr : rs5) {
      for (final Object element : arr) {
        System.out.print(element + "-");
      }
      System.out.println();
    }

    System.out.println("=====================");
    // Si se te antoja un list
    final Query q6 = s
        .createQuery("select new List(c.nombre, c.telefono) from Cliente c");
    final List<List<Object>> rs6 = q6.list();

    // Creando una clase especial para contener las columnas seleccionadas
    final Query q7 = s
        .createQuery("select new modelo.ResumenCliente(c.nombre, c.telefono) from Cliente c");
    final List<ResumenCliente> rs7 = q7.list();
    for (final ResumenCliente rc : rs7) {
      System.out.println(rc.getNombre() + "," + rc.getTelefono());
    }

    System.out.println("=====================");
    // Consultas polimorficas
    final Query q8 = s.createQuery("from Software s");
    final List<Software> rs8 = q8.list();
    for (final Software so : rs8) {
      System.out.println(so.getNombre());
    }

    final Query q9 = s
        .createQuery("from Producto p where p.class=Software or p.class=Hardware");
    final List<Producto> rs9 = q9.list();
    for (final Producto p : rs9) {
      System.out.println(p.getNombre());
    }

    final Query q10 = s.createQuery("from Producto p");
    final List<Producto> rs10 = q10.list();
    for (final Producto p : rs10) {
      System.out.println(p.getNombre());
    }

    System.out.println("=====================");
    // Funciones
    final Query q11 = s
        .createQuery("select Count(p) as cuenta from Producto p");
    final Query q11Bis = s
        .createQuery("select max(p.stock) as max from Producto p");
    final Query q11Bis2 = s
        .createQuery("select avg(p.stock) as media from Producto p");
    final List<Double> rs11 = q11Bis2.list();
    System.out.println("Media:" + rs8.get(0));

    System.out.println("=====================");
    // Expresiones
    // +, -, *, /
    // =, <=, >=, <>, !=, like
    // AND, OR, NOT
    // ()
    // IN, NOT IN, BETWEEN, , IS NULL, IS NOT NULL
    // IS EMPTY 'dame los clientes que no tienen pedidos, IS NOT EMPTY
    // EJBQL: substring(), trim(), lower(), upper(), length(), abs(), sqrt(),
    // mod()
    // current_date(), current_time(), current_timeStamp()
    final Query q12 = s
        .createQuery("from Cliente c where c.direccion.ciudad in ('Salamanca','Chinchon')");
    final List<Cliente> rs12 = q12.list();
    for (final Cliente c : rs12) {
      System.out.println(c.getNombre());
    }

    System.out.println("=====================");
    // Utilizando las colecciones
    final String str = "from Pedido p where p.detalles[0].producto.idProducto=15";

    System.out.println("=====================");
    // Order by
    final Query q13 = s.createQuery("from Cliente c order by c.nombre desc");
    final List<Cliente> rs13 = q13.list();
    for (final Cliente c : rs13) {
      System.out.println(c.getNombre());
    }

    System.out.println("=====================");
    // Group by
    final Query q14 = s
        .createQuery("select c.direccion.ciudad, count(*) from Cliente c group by c.direccion.ciudad");
    final List<Object[]> rs14 = q14.list();
    for (final Object[] arr : rs14) {
      System.out.println(arr[0] + "," + arr[1]);
    }

    System.out.println("=====================");
    // Subqueries
    final String str2 = "from Producto p where p.precio>(select avg(p.precio) from Producto p";

    System.out.println("=====================");
    // Bulk update, bulk delete
    final Query q15 = s
        .createQuery("update Producto p set p.stock=p.stock+100");
    final Query q16 = s.createQuery("delete Producto p where p.stock=0");

    // Paginacion
    final Query q17 = s.createQuery("from Cliente c");
    q17.setMaxResults(5);
    q17.setFirstResult(0);

    // 'Prepared statements'
    final Query q18 = s
        .createQuery("from Cliente c where c.direccion.ciudad=? and c.nombre like ?");
    q18.setParameter(0, "Salamanca");
    q18.setParameter(1, "A%");

    final Query q19 = s
        .createQuery("from Cliente c where c.direccion.ciudad=:ciudad and c.nombre like :letra");
    q19.setParameter("ciudad", "Salamanca");
    q19.setParameter("letra", "A%");

    s.close();
  }

}
