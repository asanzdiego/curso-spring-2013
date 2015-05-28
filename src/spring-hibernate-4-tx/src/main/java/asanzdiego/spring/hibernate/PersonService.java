package asanzdiego.spring.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

	private PersonDAO personDAO;

	@Autowired
	public void setPersonDAO(final PersonDAO personDAO) {

		this.personDAO = personDAO;
	}

	@Transactional
	public void savePersons() {

		final Person p1 = new Person();
		p1.setAge(2);
		p1.setName("qwe");
		this.personDAO.save(p1);

		final Person p2 = new Person();
		p2.setAge(9);
		p2.setName(null); // va a dar error al insertar y debería hacer rollback
		this.personDAO.save(p2);
	}

	public List<Person> listPersons() {

		return this.personDAO.list();
	}
}
