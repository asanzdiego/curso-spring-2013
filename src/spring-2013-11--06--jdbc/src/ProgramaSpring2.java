import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProgramaSpring2 {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final BasicDataSource bds = (BasicDataSource) ctx
				.getBean("MiDataSource");
		final JdbcTemplate jt = new JdbcTemplate(bds);
		final int num = jt.queryForInt("select count(*) from personas");
		System.out.println(num);

	}
}
