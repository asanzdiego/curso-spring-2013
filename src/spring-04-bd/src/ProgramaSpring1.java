import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class ProgramaSpring1 {

  public static void main(final String[] args) {

    final BeanFactory bf = new XmlBeanFactory(
        new FileSystemResource("bbdd.xml"));
    final BasicDataSource bds = (BasicDataSource) bf.getBean("miDs");
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
