import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PersonaDAOVitaminado extends HibernateDaoSupport implements
    IPersonaDAO {

  public PersonaDAOVitaminado() {

  }

  @Override
  public List<Persona> list() {

    final List<Persona> result = this.getHibernateTemplate().find(
        "select p from Persona p");
    return result;
  }

  @Override
  public void save(final Persona p) {

    this.getHibernateTemplate().saveOrUpdate(p);
  }
}
