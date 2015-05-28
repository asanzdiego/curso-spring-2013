package curso.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import curso.dao.UsuarioDao;
import curso.modelo.Usuario;

public class UsuarioDaoHibernateTemplateCursoImpl extends HibernateDaoSupport
    implements UsuarioDao {

  @Override
  public void deleteUsuario(final Integer id) {

    final Usuario u = (Usuario) this.getHibernateTemplate().get(Usuario.class,
        id);
    if (u != null) {
      this.getHibernateTemplate().delete(u);
    }
  }

  @Override
  public Usuario findUsuario(final Integer id) {

    return (Usuario) this.getHibernateTemplate().get(Usuario.class, id);
  }

  @Override
  public List listAll() {

    return this.getHibernateTemplate().find("from Usuario");
  }

  @Override
  public void saveListaUsuarios(final Usuario[] usuarios) {

    for (final Usuario usuario : usuarios) {
      this.saveUsuario(usuario);
    }
  }

  @Override
  public void saveUsuario(final Usuario usuario) {

    this.getHibernateTemplate().save(usuario);
  }
}
