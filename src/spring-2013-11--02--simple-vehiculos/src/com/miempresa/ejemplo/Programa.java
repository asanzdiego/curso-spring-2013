package com.miempresa.ejemplo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		final Vehiculo v = (Vehiculo) ctx.getBean("MiVehiculo");

		System.out.println("marca=" + v.getMarca());
		System.out.println("modelo=" + v.getMatricula());

		v.accelerar();
	}

}
