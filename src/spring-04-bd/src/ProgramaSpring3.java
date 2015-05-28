import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProgramaSpring3 {

  public static void main(final String[] args) {

    final BeanFactory bf = new XmlBeanFactory(new FileSystemResource(
        "bbdd2.xml"));
    final JdbcTemplate jt = (JdbcTemplate) bf.getBean("miJt");
    final int num = jt.queryForInt("select count(*) from personas");
    System.out.println(num);
  }
}
