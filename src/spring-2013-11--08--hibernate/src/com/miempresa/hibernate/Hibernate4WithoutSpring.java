package com.miempresa.hibernate;

import java.util.List;

public class Hibernate4WithoutSpring {

	public static void main(final String[] args) {

		final PersonDAO dao = new PersonDAOWithoutSpring();

		final Person p = new Person();
		p.setName("Alba");

		dao.save(p);

		final List<Person> persons = dao.list();

		for (final Person person : persons) {
			System.out.println(person);
		}
	}
}
