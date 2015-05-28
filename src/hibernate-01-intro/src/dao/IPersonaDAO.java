package dao;
import java.util.List;

import model.Persona;

public interface IPersonaDAO {

  public abstract List<Persona> list();

  public abstract void save(final Persona p);

}