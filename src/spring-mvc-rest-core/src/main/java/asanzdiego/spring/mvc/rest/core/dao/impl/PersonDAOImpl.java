package asanzdiego.spring.mvc.rest.core.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import asanzdiego.spring.mvc.rest.core.dao.PersonDAO;
import asanzdiego.spring.mvc.rest.core.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(final SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> list() {

        final List<Person> result = this.sessionFactory.getCurrentSession()
                .createQuery("from Person").list();
        return result;
    }

    @Transactional
    public void save(final Person person) {

        this.sessionFactory.getCurrentSession().save(person);
    }

    @Transactional
    public void update(final Person person) {

        this.sessionFactory.getCurrentSession().update(person);
    }

    @Transactional
    public Person get(final Integer personId) {

        return (Person) this.sessionFactory.getCurrentSession().get(
                Person.class, personId);
    }

    @Transactional
    public void delete(final Integer personId) {

        final Person person = new Person();
        person.setId(personId);
        this.sessionFactory.getCurrentSession().delete(person);
    }

}
