package com.miempresa.ejemplo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final Persona p = (Persona) ctx.getBean("MiPersona");

		System.out.println(p);
		System.out.println("Pareja=" + p.getPareja());
	}

}
