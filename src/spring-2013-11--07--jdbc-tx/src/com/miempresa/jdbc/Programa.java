package com.miempresa.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final IPersonaService s = (IPersonaService) ctx
				.getBean("MiPersonaService");

		s.deletePersonas();
		s.insertPersona("adolfo");
		try {
			s.insertPersonas();
		} catch (final Exception e) {
			System.out.println(e);
		}
		s.selectPersonas();
	}

}
