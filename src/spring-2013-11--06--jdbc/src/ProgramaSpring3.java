import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProgramaSpring3 {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final JdbcTemplate jt = (JdbcTemplate) ctx.getBean("MiJdbcTemplate");
		final int num = jt.queryForInt("select count(*) from personas");
		System.out.println(num);

	}
}
