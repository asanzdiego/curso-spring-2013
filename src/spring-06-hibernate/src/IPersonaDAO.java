import java.util.List;

public interface IPersonaDAO {

  public abstract List<Persona> list();

  public abstract void save(final Persona p);

}