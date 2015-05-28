package asanzdiego.spring.bd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcWithSpring {

	public static void main(final String[] args) {

		final ApplicationContext appCxt = new ClassPathXmlApplicationContext(
				"app-context.xml");
		final JdbcTemplate jt = (JdbcTemplate) appCxt.getBean("myJdbcTemplate");
		final int num = jt.queryForInt("select count(*) from test");
		System.out.println(num);
	}
}
