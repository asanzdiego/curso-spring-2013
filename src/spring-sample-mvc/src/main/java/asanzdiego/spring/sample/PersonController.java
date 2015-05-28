package asanzdiego.spring.sample;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import asanzdiego.spring.sample.core.model.Person;
import asanzdiego.spring.sample.core.service.PersonService;

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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(final Model model) {

		PersonController.logger.info(">>> list");

		final List<Person> persons = this.personService.listPersons();
		model.addAttribute("persons", persons);

		return "person/list";
	}

	@RequestMapping(value = "/delete/{personName}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("personName") final String personName,
			final Model model) {

		PersonController.logger.info(">>> delete");

		this.personService.deletePerson(personName);

		return "redirect:/person/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveGet(@RequestParam("name") final String personName,
			@RequestParam("age") final Integer personAge) {

		PersonController.logger.info(">>> saveGet");

		final Person person = new Person();
		person.setName(personName);
		person.setAge(personAge);

		this.personService.savePerson(person);

		return "redirect:/person/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView savePost(@Valid final Person person,
			final BindingResult bindingResult) {

		PersonController.logger.info(">>> savePost");

		if (!bindingResult.hasErrors()) {

			this.personService.savePerson(person);
		}

		final ModelAndView modelAndView = new ModelAndView("/person/list");
		final List<Person> persons = this.personService.listPersons();
		modelAndView.addObject("persons", persons);

		return modelAndView;
	}

}
