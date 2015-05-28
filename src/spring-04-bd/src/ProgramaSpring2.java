import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProgramaSpring2 {

  public static void main(final String[] args) {

    final BeanFactory bf = new XmlBeanFactory(
        new FileSystemResource("bbdd.xml"));
    final BasicDataSource bds = (BasicDataSource) bf.getBean("miDs");
    final JdbcTemplate jt = new JdbcTemplate(bds);
    final int num = jt.queryForInt("select count(*) from personas");
    System.out.println(num);
  }
}
