package asanzdiego.spring.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class JdbcWithoutSpring {

	public static void main(final String[] args) {

		final BasicDataSource bds = new BasicDataSource();
		bds.setUrl("jdbc:h2:~/test");
		bds.setDriverClassName("org.h2.Driver");
		bds.setUsername("sa");
		bds.setPassword("");
		Connection cn = null;
		try {
			cn = bds.getConnection();
			final PreparedStatement pst = cn
					.prepareStatement("select count(*) from test");
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
