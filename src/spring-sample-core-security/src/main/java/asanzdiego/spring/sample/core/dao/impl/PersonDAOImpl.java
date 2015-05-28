package asanzdiego.spring.sample.core.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import asanzdiego.spring.sample.core.dao.PersonDAO;
import asanzdiego.spring.sample.core.model.Person;

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

		this.sessionFactory.getCurrentSession().saveOrUpdate(person);
	}

	@Transactional
	public Person get(final String personName) {

		return (Person) this.sessionFactory.getCurrentSession().get(
				Person.class, personName);
	}

	@Transactional
	public void delete(final String personName) {

		final Person person = new Person();
		person.setPersonName(personName);
		this.sessionFactory.getCurrentSession().delete(person);
	}

}
