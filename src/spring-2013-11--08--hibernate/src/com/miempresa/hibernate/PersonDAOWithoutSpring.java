package com.miempresa.hibernate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDAOWithoutSpring implements PersonDAO {

	private static final SessionFactory sf;

	static {
		sf = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();
	}

	@Override
	public List<Person> list() {

		final Session s = PersonDAOWithoutSpring.sf.openSession();
		final Query q = s.createQuery("from Person");
		final List<Person> result = q.list();
		s.close();
		return result;
	}

	@Override
	public void save(final Person person) {

		final Session s = PersonDAOWithoutSpring.sf.openSession();
		s.beginTransaction();
		s.save(person);
		s.getTransaction().commit();
		s.close();

	}

}
