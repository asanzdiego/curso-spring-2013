package asanzdiego.spring.mvc.rest.core.dao;

import java.util.List;

import asanzdiego.spring.mvc.rest.core.model.Person;

public interface PersonDAO {

    public abstract List<Person> list();

    public abstract void save(final Person person);

    public abstract void update(final Person person);

    public Person get(final Integer personId);

    public abstract void delete(final Integer personId);
}