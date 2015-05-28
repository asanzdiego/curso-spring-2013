package asanzdiego.spring.sample.core.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asanzdiego.spring.sample.core.dao.PersonDAO;
import asanzdiego.spring.sample.core.model.Person;
import asanzdiego.spring.sample.core.model.Rol;
import asanzdiego.spring.sample.core.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	@Autowired
	public void setPersonDAO(final PersonDAO personDAO) {

		this.personDAO = personDAO;
	}

	public List<Person> listPersons() {

		return this.personDAO.list();
	}

	public void savePerson(final Person person) {

		final Set<Rol> roles = new HashSet<Rol>();
		roles.add(new Rol("user"));

		if ((person.getPersonName() != null)
				&& person.getPersonName().startsWith("a")) {

			roles.add(new Rol("admin"));
		}

		person.setRoles(roles);

		this.personDAO.save(person);
	}

	public Person getPerson(final String personName) {

		return this.personDAO.get(personName);
	}

	public void deletePerson(final String personName) {

		this.personDAO.delete(personName);
	}
}
