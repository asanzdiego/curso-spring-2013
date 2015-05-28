package curso.dao.impl2;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import curso.modelo.Usuario;

public class UsuarioDaoOtraImpl implements curso.dao.UsuarioDao {

  private static final Log log = LogFactory.getLog(UsuarioDaoOtraImpl.class);

  private static HashMap tabla;

  public UsuarioDaoOtraImpl() {

    log.debug("Constructor de la implementacion DAO");
    tabla = new HashMap();
  }

  @Override
  public void saveUsuario(final Usuario usuario) {

    log.debug("Guardamos el usuario " + usuario);
    if (usuario != null) {
      tabla.put(usuario.getId(), usuario);
    }
  }

  @Override
  public Usuario findUsuario(final Integer id) {

    log.debug("Estamos buscando usuario " + id);
    return (Usuario) tabla.get(id);
  }

  @Override
  public void deleteUsuario(final Integer id) {

    log.debug("Borramos el usuario " + id);
    tabla.remove(id);
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