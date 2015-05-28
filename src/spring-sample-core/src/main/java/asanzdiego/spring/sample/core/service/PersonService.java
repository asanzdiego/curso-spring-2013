package asanzdiego.spring.sample.core.service;

import java.util.List;

import asanzdiego.spring.sample.core.model.Person;

public interface PersonService {

	public abstract List<Person> listPersons();

	public abstract void savePerson(final Person person);

	public Person getPerson(final String personName);

	public abstract void deletePerson(final String personName);
}