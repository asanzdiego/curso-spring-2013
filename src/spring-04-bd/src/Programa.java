import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Programa {

  public static void main(final String[] args) {

    final BasicDataSource bds = new BasicDataSource();
    bds.setUrl("jdbc:mysql:///clase");
    bds.setDriverClassName("com.mysql.jdbc.Driver");
    bds.setUsername("clase");
    bds.setPassword("clase");
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
