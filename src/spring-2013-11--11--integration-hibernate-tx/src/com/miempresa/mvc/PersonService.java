package com.miempresa.mvc;

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
	public Person getPerson(final Integer personID) {

		return this.personDAO.get(personID);
	}

	@Transactional
	public Person deletePerson(final Integer personID) {

		return this.personDAO.delete(personID);
	}

	@Transactional
	public Person createPerson(final Person person) {

		return this.personDAO.save(person);
	}

	@Transactional
	public Person updatePerson(final Integer personId, final Person person) {

		person.setId(personId);
		return this.personDAO.save(person);
	}

	public List<Person> listPersons() {

		return this.personDAO.list();
	}
}
