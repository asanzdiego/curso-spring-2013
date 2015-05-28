package com.miempresa.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
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
	public void save(final Person person) {

		this.sessionFactory.getCurrentSession().save(person);

	}
}
