import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaSpring1 {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final BasicDataSource bds = (BasicDataSource) ctx
				.getBean("MiDataSource");
		Connection cn = null;
		try {
			cn = bds.getConnection();
			final PreparedStatement pst = cn
					.prepareStatement("select count(*) from personas");
			final ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
