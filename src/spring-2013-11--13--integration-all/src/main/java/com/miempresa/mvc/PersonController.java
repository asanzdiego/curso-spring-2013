package com.miempresa.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PersonController {

	private PersonService2 personService2;

	private static final Logger logger = LoggerFactory
			.getLogger(PersonController.class);

	@Autowired
	public void setPersonService2(final PersonService2 personService2) {
		this.personService2 = personService2;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public MessageWeb handleException(final Exception e) {

		PersonController.logger.info(e.toString());

		return new MessageWeb(e.getMessage());
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> list() {

		PersonController.logger.info("GET -> List persons");

		final List<Person> persons = this.personService2.listPersons();

		return persons;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Person create(@RequestBody final Person person) {

		PersonController.logger.info("POST > Create person");

		final Person createdPerson = this.personService2.createPerson(person);

		return createdPerson;
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
	@ResponseBody
	public Person get(@PathVariable("personId") final Integer personId) {

		PersonController.logger.info("GET > perosonId=" + personId);

		final Person person = this.personService2.getPerson(personId);

		return person;
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.PUT)
	@ResponseBody
	public Person update(@PathVariable("personId") final Integer personId,
			@RequestBody final Person person) {

		PersonController.logger.info("PUT > perosonId=" + personId);

		final Person updatedPerson = this.personService2.updatePerson(personId,
				person);

		return updatedPerson;
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Person detele(@PathVariable("personId") final Integer personId) {

		PersonController.logger.info("DELETE > perosonId=" + personId);

		final Person deletedPerson = this.personService2.deletePerson(personId);

		return deletedPerson;
	}
}
