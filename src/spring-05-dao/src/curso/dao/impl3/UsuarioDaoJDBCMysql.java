package curso.dao.impl3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import curso.dao.UsuarioDao;
import curso.modelo.Usuario;

public class UsuarioDaoJDBCMysql implements UsuarioDao {

  private static final Log log = LogFactory.getLog(UsuarioDaoJDBCMysql.class);

  private DataSource ds;

  public DataSource getDs() {

    return this.ds;
  }

  public void setDs(final DataSource ds) {

    this.ds = ds;
  }

  public UsuarioDaoJDBCMysql() {

    log.debug("Constructor de la implementacion DAO");

  }

  @Override
  public void saveUsuario(final Usuario usuario) {

    log.debug("Guardamos el usuario " + usuario);
    Connection cn = null;
    if (usuario != null) {
      try {
        cn = this.ds.getConnection();
        cn.createStatement().executeUpdate(
            "insert into usuarios values(" + usuario.getId() + ",'"
                + usuario.getNombre() + "')");
      } catch (final SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          cn.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Override
  public Usuario findUsuario(final Integer id) {

    log.debug("Estamos buscando usuario " + id);
    Usuario u = null;
    Connection cn = null;

    try {
      cn = this.ds.getConnection();
      final ResultSet rs = cn.createStatement().executeQuery(
          "select * from usuarios where id=" + id);
      if (rs.next()) {
        u = new Usuario(rs.getInt(1), rs.getString(2));
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        cn.close();
      } catch (final SQLException e) {
        e.printStackTrace();
      }
    }
    return u;
  }

  @Override
  public void deleteUsuario(final Integer id) {

    log.debug("Borramos el usuario " + id);
    Connection cn = null;

    try {
      cn = this.ds.getConnection();
      cn.createStatement().executeUpdate("delete from usuarios where id=" + id);
    } catch (final SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        cn.close();
      } catch (final SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public List listAll() {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveListaUsuarios(final Usuario[] usuario) {

    // TODO Auto-generated method stub

  }
}