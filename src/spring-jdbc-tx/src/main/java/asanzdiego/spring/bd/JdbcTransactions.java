package asanzdiego.spring.bd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTransactions {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");

		final TestDAO testDAO = (TestDAO) appCxt.getBean("myTestDAO");

		testDAO.deleteTests();

		testDAO.insertTest(10, "diez");

		try {
			testDAO.insertTests();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		testDAO.printTestList();
	}

}
