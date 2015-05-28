package dao;

import java.util.List;

import model.Persona;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonaDAO implements IPersonaDAO {

  private static final SessionFactory sf;

  static {
    sf = new Configuration().configure("model/hibernate.cfg.xml")
        .buildSessionFactory();
  }

  public PersonaDAO() {

  }

  @Override
  public List<Persona> list() {

    final Session s = sf.openSession();
    final Query q = s.createQuery("select p from Persona p");
    final List<Persona> result = q.list();
    sf.close();
    return result;
  }

  @Override
  public void save(final Persona p) {

    final Session s = sf.openSession();
    s.saveOrUpdate(p);
    sf.close();
  }

  public Persona get(final int idPersona) {

    final Session s = sf.openSession();
    final Persona result = (Persona) s.get(Persona.class, 1);
    sf.close();
    return result;
  }
}
