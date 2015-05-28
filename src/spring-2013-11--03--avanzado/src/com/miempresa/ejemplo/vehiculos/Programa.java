package com.miempresa.ejemplo.vehiculos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-vehiculos.xml");

		final Vehiculo v = (Vehiculo) ctx.getBean("MiVehiculo");

		System.out.println("marca=" + v.getMarca());
		System.out.println("modelo=" + v.getMatricula());

		v.accelerar();
	}

}
