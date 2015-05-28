package asanzdiego.spring.sample.core.dao;

import java.util.List;

import asanzdiego.spring.sample.core.model.Person;

public interface PersonDAO {

	public abstract List<Person> list();

	public abstract void save(final Person person);

	public Person get(final String personName);

	public abstract void delete(final String personName);
}