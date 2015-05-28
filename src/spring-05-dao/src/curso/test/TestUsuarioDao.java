package curso.test;

import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import curso.dao.UsuarioDao;
import curso.modelo.Usuario;

public class TestUsuarioDao extends TestCase {

  public final static Log log = LogFactory.getLog(TestUsuarioDao.class);

  ApplicationContext ctx;

  Usuario usuario;

  UsuarioDao dao;

  @Override
  protected void setUp() throws Exception {

    log.debug("preparando el test");
    this.ctx = new ClassPathXmlApplicationContext(
        "applicationContext.HCurso.xml");
    this.dao = (UsuarioDao) this.ctx.getBean("miDao");

    // UsuarioDaoJDBCMysql dao=new UsuarioDaoJDBCMysql();
    // BasicDataSource ds=new BasicDataSource();
    // ds.setDriverClassName("com.mysql.jdbc.Driver");
    // ds.setUrl("jdbc:mysql:///test");
    // ds.setUsername("root");
    // ds.setPassword("root");
    // dao.setDs(ds);
    // this.dao=dao;
  }

  @Override
  protected void tearDown() throws Exception {

    this.usuario = null;
    this.dao = null;
    log.debug("fin del test");
  }

  public void testUsuarioDao() {

    // Solo para verificar que hay conexion y no salta excepcion
    this.usuario = new Usuario();
    this.usuario.setId(new Integer(1));
    this.usuario.setNombre("Nombre usuario");
    this.dao.saveUsuario(this.usuario);
    this.usuario = this.dao.findUsuario(new Integer(1));
    // encontramos el mismo usuario que grabamos
    assertTrue(this.usuario != null);

    Usuario usuario2 = this.dao.findUsuario(new Integer(1));
    log.info("Recuperado usuario" + usuario2);
    assertTrue(usuario2 != null);
    log.info("Comparamos : " + usuario2 + " con : " + this.usuario);
    assertTrue(usuario2.equals(this.usuario));
    // recuperamos el mismo usuario
    this.dao.deleteUsuario(new Integer(1));
    usuario2 = this.dao.findUsuario(new Integer(1));
    assertNull("El usuario no debe de existir", usuario2);
  }

  /**
   * Realiza el test de insercion de datos malos que provoquen un efecto de
   * rollback en las transacciones.
   * 
   * @throws Exception
   *           excepcion generada.
   */
  public void testTransaccion() throws Exception {

    log.debug("Iniciamos guardar todos los usuarios:");
    final Usuario[] usuarios = this.ListadoUsuarios();
    log.debug(usuarios);
    try {
      this.dao.saveListaUsuarios(usuarios);
    } catch (final Exception e) {
      log.error(e);
      final List listado = this.dao.listAll();
      log.debug("La lista debe de estar vacia");
      assertTrue(listado.isEmpty());
    }
  }

  /**
   * @return Un listado de usuarios con algunos datos malos
   */
  private Usuario[] ListadoUsuarios() {

    final Usuario usu1 = new Usuario();
    usu1.setId(new Integer(100));
    usu1.setNombre("Nombre uno");
    final Usuario usu2 = new Usuario();
    usu2.setId(new Integer(101));
    usu2.setNombre("Nombre dos");
    // Es es un usuario no valido
    final Usuario usu3 = new Usuario();
    usu3.setId(null);
    usu3.setNombre("Usuario no valido");
    final Usuario usu4 = new Usuario();
    usu4.setId(new Integer(103));
    usu4.setNombre("Nombre cuatro");
    final Usuario[] usuarios = { usu1, usu2, usu3, usu4 };
    return usuarios;
  }

}
