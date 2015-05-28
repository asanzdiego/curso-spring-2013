package com.miempresa.ejemplo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.miempresa.ejemplo.parejas.Persona;
import com.miempresa.ejemplo.vehiculos.Factoria;
import com.miempresa.ejemplo.vehiculos.Vehiculo;

public class Programa {

	public static void main(final String[] args) {

		final String[] ficherosSpring = new String[] { "spring-parejas.xml",
				"spring-vehiculos.xml" };

		final ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				ficherosSpring);

		final Persona p1 = (Persona) ctx.getBean("MiPersona");

		System.out.println(p1);
		System.out.println("Pareja=" + p1.getPareja());

		final Persona p2 = (Persona) ctx.getBean("MiOtraPersona");
		p1.setPareja(p2);

		System.out.println(p2);
		System.out.println("Pareja=" + p2.getPareja());

		final Vehiculo v1 = (Vehiculo) ctx.getBean("MiVehiculo1");
		final Vehiculo v11 = (Vehiculo) ctx.getBean("MiVehiculo1");

		final Vehiculo v2 = (Vehiculo) ctx.getBean("MiVehiculo2");
		final Vehiculo v22 = (Vehiculo) ctx.getBean("MiVehiculo2");

		System.out.println("Vehiviculo1=" + v1);
		v1.accelerar();
		System.out.println("Vehiviculo11=" + v11);
		v11.accelerar();

		System.out.println("Vehiviculo=2" + v2);
		v22.accelerar();

		System.out.println("Vehiviculo=22" + v22);
		v22.accelerar();

		final Factoria f1 = Factoria.getInstancia();
		System.out.println(f1);

		final Factoria f2 = Factoria.getInstancia();
		System.out.println(f2);

		final Vehiculo v3 = (Vehiculo) ctx.getBean("MiVehiculoConFactoria");
		System.out.println("Vehiviculo=3" + v3);

		ctx.close();
	}
}
