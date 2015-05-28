package asanzdiego.spring.mvc.rest.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asanzdiego.spring.mvc.rest.core.dao.PersonDAO;
import asanzdiego.spring.mvc.rest.core.model.Person;
import asanzdiego.spring.mvc.rest.core.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(final PersonDAO personDAO) {

        this.personDAO = personDAO;
    }

    public List<Person> list() {

        return personDAO.list();
    }

    public void save(final Person person) {

        personDAO.save(person);
    }

    public void update(final Person person) {

        personDAO.update(person);
    }

    public Person get(final Integer personId) {

        return personDAO.get(personId);
    }

    public void delete(final Integer personId) {

        personDAO.delete(personId);
    }

}
