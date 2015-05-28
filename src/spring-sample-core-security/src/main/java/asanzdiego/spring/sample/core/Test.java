package asanzdiego.spring.sample.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import asanzdiego.spring.sample.core.model.Person;
import asanzdiego.spring.sample.core.service.PersonService;

public class Test {

	public static void main(final String[] args) {

		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final PersonService personService = applicationContext
				.getBean(PersonService.class);

		final Person p1 = new Person();
		p1.setPersonName("adolfo");
		p1.setPersonPassword("123456");
		p1.setPersonEnabled(true);
		p1.setPersonAge(21);

		personService.savePerson(p1);

		final Person p2 = new Person();
		p2.setPersonName("ursula");
		p2.setPersonPassword("654321");
		p2.setPersonEnabled(false);
		p2.setPersonAge(22);

		personService.savePerson(p2);

		final Person p3 = new Person();
		p3.setPersonName("alfonso");
		p3.setPersonPassword("123123");
		p3.setPersonEnabled(false);
		p3.setPersonAge(23);

		personService.savePerson(p3);

		final List<Person> persons = personService.listPersons();
		for (final Person p : persons) {
			System.out.println(p);
		}
	}
}
