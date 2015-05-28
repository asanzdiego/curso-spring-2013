package com.miempresa.mvc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final PersonService service = (PersonService) appCxt
				.getBean("personService");

		final Person person1 = service.createPerson(new Person(null, "adolfo",
				21));
		final Person person2 = service.createPerson(new Person(null, "pepito",
				22));

		final List<Person> persons1 = service.listPersons();

		for (final Person person : persons1) {
			System.out.println(person);
		}

		System.out.println("-----------------------------");

		person1.setName("fulanito");
		service.updatePerson(person1.getId(), person1);

		service.deletePerson(person2.getId());

		final List<Person> persons2 = service.listPersons();

		for (final Person person : persons2) {
			System.out.println(person);
		}
	}
}
