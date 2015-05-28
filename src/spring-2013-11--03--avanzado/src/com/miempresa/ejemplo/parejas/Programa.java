package com.miempresa.ejemplo.parejas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-parejas.xml");

		final Persona p = (Persona) ctx.getBean("MiPersona");

		System.out.println(p);
		System.out.println("Pareja=" + p.getPareja());
	}

}
