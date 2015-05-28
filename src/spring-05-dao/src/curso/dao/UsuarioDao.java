package curso.dao;

import java.util.List;

import curso.modelo.Usuario;

public interface UsuarioDao {

  public void saveUsuario(Usuario usuario);

  public Usuario findUsuario(Integer id);

  public void deleteUsuario(Integer id);

  public List listAll();

  public void saveListaUsuarios(Usuario[] usuario);

}
