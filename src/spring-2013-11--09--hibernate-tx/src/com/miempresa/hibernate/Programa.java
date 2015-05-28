package com.miempresa.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final PersonService service = (PersonService) appCxt
				.getBean("personService");

		try {
			service.savePersons();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		final List<Person> persons = service.listPersons();

		for (final Person person : persons) {
			System.out.println(person);
		}
	}
}
