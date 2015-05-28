package asanzdiego.spring.sample;

import java.security.Principal;
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
	public String list(final Model model, final Principal principal) {

		PersonController.logger.info(">>> list");

		final String name = principal.getName();
		model.addAttribute("personName", name);

		final List<Person> persons = this.personService.listPersons();
		model.addAttribute("persons", persons);
		model.addAttribute("person", new Person());

		return "person/list";
	}

	@RequestMapping(value = "/delete/{personName}",
			method = RequestMethod.DELETE)
	public String delete(@PathVariable("personName") final String personName,
			final Model model) {

		PersonController.logger.info(">>> delete");

		this.personService.deletePerson(personName);

		return "redirect:/person/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid final Person person,
			final BindingResult bindingResult, final Principal principal) {

		PersonController.logger.info(">>> save");

		if (!bindingResult.hasErrors()) {

			this.personService.savePerson(person);
		}

		final ModelAndView modelAndView = new ModelAndView("/person/list");
		modelAndView.addObject("person", person);

		final String name = principal.getName();
		modelAndView.addObject("personName", name);

		final List<Person> persons = this.personService.listPersons();
		modelAndView.addObject("persons", persons);

		return modelAndView;
	}

}
