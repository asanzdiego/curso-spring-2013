package asanzdiego.spring.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hibernate3Transactions {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final PersonService personService = (PersonService) appCxt
				.getBean("myPersonService");

		try {
			personService.savePersons();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		final List<Person> persons = personService.listPersons();

		for (final Person person : persons) {
			System.out.println(person);
		}
	}
}
