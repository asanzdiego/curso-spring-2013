package curso.dao.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import curso.dao.UsuarioDao;
import curso.modelo.Usuario;

public class UsuarioDaoJDBCTemplate extends JdbcDaoSupport implements
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
          "select * from usuarios where id=" + id, new RowMapper() {

            @Override
            public Object mapRow(final ResultSet rs, final int count)
                throws SQLException {

              return new Usuario(rs.getInt("id"), rs.getString("nombre"));
            }
          });
    } catch (final EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public List listAll() {

    final List lista = new ArrayList(this.getJdbcTemplate().queryForInt(
        "select count(*) from personas"));
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
  public void saveUsuario(final Usuario usuario) {

    this.getJdbcTemplate().update("insert into usuarios values(?,?)",
        new Object[] { usuario.getId(), usuario.getNombre() });

  }

  @Override
  public void saveListaUsuarios(final Usuario[] usuarios) {

    for (final Usuario u : usuarios) {
      this.saveUsuario(u);
    }

  }

}
