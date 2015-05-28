
import java.util.List;

public interface PersonaDao {

  public void guardar(Persona p);

  public void borrar(Persona p);

  public List<Persona> listar();

  public Persona buscar(String n);

}
