package com.miempresa.mvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory
			.getLogger(PersonController.class);

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

		PersonController.logger.info("List persons");

		final List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1, "Pepito1", 1));
		persons.add(new Person(2, "Pepito2", 2));
		persons.add(new Person(3, "Pepito3", 3));
		persons.add(new Person(4, "Pepito4", 4));

		if (true) {
			throw new RuntimeException("jajaja you are here");
		}
		return persons;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Person create(@RequestBody final Person person) {

		PersonController.logger.info("Create person");
		PersonController.logger.info(person.toString());

		return new Person(1, "Pepito1", 1);
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
	@ResponseBody
	public Person get(@PathVariable("personId") final Integer personId) {

		PersonController.logger.info("perosona=" + personId);

		switch (personId) {
		case 1:
			return new Person(1, "Pepito1", 1);
		case 2:
			return new Person(2, "Pepito2", 2);
		default:
			throw new RuntimeException("NOT FOUND");
		}
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.PUT)
	@ResponseBody
	public Person update(@PathVariable("personId") final Integer personId,
			@RequestBody final Person person) {

		PersonController.logger.info("perosona=" + personId);

		switch (personId) {
		case 1:
			return new Person(1, person.getName(), person.getAge());
		case 2:
			return new Person(2, person.getName(), person.getAge());
		default:
			throw new RuntimeException("NOT FOUND");
		}
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.DELETE)
	@ResponseBody
	public MessageWeb detele(@PathVariable("personId") final Integer personId) {

		PersonController.logger.info("perosona=" + personId);

		return new MessageWeb("perosona=" + personId + " borrada");
	}
}
