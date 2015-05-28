package curso.dao.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import curso.dao.UsuarioDao;
import curso.modelo.Usuario;

//public class UsuarioDaoJdbcTemplateCursoImpl extends AbstractJdbcDaoTemplate implements UsuarioDao {
public class UsuarioDaoJdbcTemplateCursoImpl extends JdbcDaoSupport implements
    UsuarioDao {

  @Override
  public void deleteUsuario(final Integer id) {

    this.getJdbcTemplate().update("delete from usuarios where id=?",
        new Object[] { id });
  }

  @Override
  public Usuario findUsuario(final Integer id) {

    try {
      return (Usuario) this.getJdbcTemplate().queryForObject(
          "select * from usuarios where id=?", new Object[] { id },
          new RowMapper() {

            @Override
            public Object mapRow(final ResultSet rs, final int rowNum)
                throws SQLException {

              return new Usuario(rs.getInt("id"), rs.getString("nombre"));
            }
          });
    } catch (final DataAccessException e) {
      return null;
    }
  }

  @Override
  public List listAll() {

    final List<Usuario> lista = new ArrayList<Usuario>(this.getJdbcTemplate()
        .queryForInt("select count(*) from usuarios"));

    this.getJdbcTemplate().query("select * from usuarios",
        new RowCallbackHandler() {

          @Override
          public void processRow(final ResultSet rs) throws SQLException {

            lista.add(new Usuario(rs.getInt("id"), rs.getString("nombre")));
          }
        });

    return lista;
  }

  @Override
  public void saveListaUsuarios(final Usuario[] usuarios) {

    for (final Usuario usuario : usuarios) {
      this.saveUsuario(usuario);
    }

  }

  @Override
  public void saveUsuario(final Usuario u) {

    this.getJdbcTemplate().update("insert into usuarios values(?,?)",
        new Object[] { u.getId(), u.getNombre() },
        new int[] { java.sql.Types.INTEGER, java.sql.Types.VARCHAR });
  }
}
