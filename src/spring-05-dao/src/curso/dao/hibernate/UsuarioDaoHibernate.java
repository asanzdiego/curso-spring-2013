package curso.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import curso.dao.UsuarioDao;
import curso.modelo.Usuario;

// Extiende de una clase que proporciona los metodos necesarios para acceder a Hibernate
public class UsuarioDaoHibernate extends HibernateDaoSupport implements
    UsuarioDao {

  @Override
  public void saveUsuario(final Usuario usuario) {

    this.logger.debug("Intentamos guardar el usuario " + usuario);
    final HibernateTemplate temp = this.getHibernateTemplate();
    if (usuario != null) {
      final List listado = temp.find("FROM " + Usuario.class.getName()
          + " as usuario where usuario.id =" + usuario.getId());
      if (listado.isEmpty()) {
        this.logger.debug("No contiene , hacemos un save");
        temp.save(usuario);
      } else {
        this.logger.debug("Contiene, hacemos un update");
        temp.update(usuario);
      }
    }
  }

  @Override
  public Usuario findUsuario(final Integer id) {

    this.logger.debug("Buscamos el usuario " + id);
    return (Usuario) this.getHibernateTemplate().get(Usuario.class, id);
  }

  @Override
  public void deleteUsuario(final Integer id) {

    this.logger.debug("Borramos el usuario " + id);
    final Usuario usu = (Usuario) this.getHibernateTemplate().load(
        Usuario.class, id);
    this.getHibernateTemplate().delete(usu);

  }

  @Override
  public void saveListaUsuarios(final Usuario[] usuario) {

    this.logger.debug("Guardamos todos los usuarios");
    final HibernateTemplate temp = this.getHibernateTemplate();
    for (int i = 0; i < usuario.length; i++) {
      this.logger.debug("Guardando " + usuario[i] + " i : " + i);
      temp.save(usuario[i]);
    }
  }

  @Override
  public List listAll() {

    return this.getHibernateTemplate().find("From Usuario");
  }
}