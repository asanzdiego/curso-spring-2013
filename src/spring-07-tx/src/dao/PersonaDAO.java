package dao;

import java.util.List;

import model.Persona;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PersonaDAO extends HibernateDaoSupport implements IPersonaDAO {

  public PersonaDAO() {

  }

  @Override
  public List<Persona> list() {

    final List<Persona> result = this.getHibernateTemplate().find(
        "select p from Persona p");
    return result;
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
  public void save(final Persona p) {

    this.getHibernateTemplate().saveOrUpdate(p);
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
  public void savePersonas(final List<Persona> personas) {

    for (final Persona persona : personas) {
      this.save(persona);
    }
    throw new RuntimeException("cuando me lancen deberían hacer un rollback");

  }
}
