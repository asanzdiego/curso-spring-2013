package asanzdiego.spring.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class PersonDAOImpl implements PersonDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(final SessionFactory sessionFactory) {

		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public List<Person> list() {

		final List<Person> result = this.hibernateTemplate.find("from Person");
		return result;
	}

	@Transactional
	public void save(final Person person) {

		this.hibernateTemplate.save(person);
	}

}
