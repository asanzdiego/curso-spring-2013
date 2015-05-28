package asanzdiego.spring.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hibernate3WithSpring {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final PersonDAO dao = (PersonDAOWithSpring) appCxt.getBean("dao");

		final Person p = new Person();
		p.setAge(2);
		p.setName("Alba");

		dao.save(p);

		final List<Person> persons = dao.list();

		for (final Person person : persons) {
			System.out.println(person);
		}
	}
}
