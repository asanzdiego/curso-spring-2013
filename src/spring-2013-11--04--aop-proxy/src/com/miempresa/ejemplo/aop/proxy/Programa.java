package com.miempresa.ejemplo.aop.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-aop.xml");

		final Persona p = (Persona) ctx.getBean("MiPersonaProxy");

		System.out.println(p);
		System.out.println("Pareja=" + p.getPareja());

		p.setNombre("pepito");
		p.setEdad(35);

		System.out.println(p);
		System.out.println("Pareja=" + p.getPareja());

	}

}
