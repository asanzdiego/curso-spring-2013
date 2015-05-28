package asanzdiego.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class App {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final Person p1 = (Person) appCxt.getBean("myPersonProxy");
		System.out.println(p1);
		p1.setAge(5);
		System.out.println(p1);

		final Pet p2 = (Pet) appCxt.getBean("myPetProxy");
		System.out.println(p2);
		p2.setAge(5);
		System.out.println(p2);
	}
}
