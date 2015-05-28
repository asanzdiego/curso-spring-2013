package asanzdiego.spring.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class PersonDAOWithSpring implements PersonDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(final SessionFactory sessionFactory) {

		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<Person> list() {

		final List<Person> result = this.hibernateTemplate.find("from Person");
		return result;
	}

	public void save(final Person person) {

		this.hibernateTemplate.save(person);

	}
}
