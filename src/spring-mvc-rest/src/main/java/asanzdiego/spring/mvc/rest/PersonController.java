package asanzdiego.spring.mvc.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import asanzdiego.spring.mvc.rest.core.model.Person;
import asanzdiego.spring.mvc.rest.core.service.PersonService;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private static final Logger logger = LoggerFactory
            .getLogger(PersonController.class);

    private PersonService personService;

    @Autowired
    public void setPersonService(final PersonService personService) {

        this.personService = personService;
    }

    @ExceptionHandler(Exception.class)
    public void handleException(final Exception e,
            final HttpServletResponse response) throws Exception {

        PersonController.logger.info(">>> error");
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.toString());
        PersonController.logger.error("INTERNAL_SERVER_ERROR", e);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Person> list() {

        PersonController.logger.info(">>> list");

        final List<Person> persons = personService.list();

        return persons;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody final Person person) {

        PersonController.logger.info(">>> save " + person);

        personService.save(person);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("personId") final Integer personId,
            @RequestBody final Person person) {

        PersonController.logger.info(">>> update " + personId + " - " + person);

        personService.update(person);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    @ResponseBody
    public Person get(@PathVariable("personId") final Integer personId) {

        PersonController.logger.info(">>> get " + personId);

        final Person person = personService.get(personId);

        return person;
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("personId") final Integer personId) {

        PersonController.logger.info(">>> delete " + personId);

        personService.delete(personId);
    }

}
