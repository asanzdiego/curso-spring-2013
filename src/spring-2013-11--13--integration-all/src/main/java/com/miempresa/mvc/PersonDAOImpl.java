package com.miempresa.mvc;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Person> list() {

		final List<Person> result = this.sessionFactory.getCurrentSession()
				.createQuery("from Person").list();
		return result;
	}

	@Override
	@Transactional
	public Person save(final Person person) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(person);

		return person;

	}

	@Override
	@Transactional
	public Person get(final Integer personID) {

		return (Person) this.sessionFactory.getCurrentSession().get(
				Person.class, personID);
	}

	@Override
	@Transactional
	public Person delete(final Integer personID) {

		final Person person = (Person) this.sessionFactory.getCurrentSession()
				.get(Person.class, personID);

		this.sessionFactory.getCurrentSession().delete(person);

		return person;
	}
}
