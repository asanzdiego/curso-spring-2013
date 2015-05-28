package com.miempresa.ejemplo.vehiculos;

import java.util.Date;

public class Factoria {

	private static Factoria instancia;

	static {
		Factoria.instancia = new Factoria();
	}

	private Factoria() {
		System.out.println(super.toString() + " creada la instancia Factoria");
	}

	public static Factoria getInstancia() {
		return Factoria.instancia;
	}

	public Vehiculo getVehiculo() {

		final Date now = new Date();

		Vehiculo v;

		if ((now.getTime() % 2) == 0) {
			v = new Coche("Audi", "" + now.getTime());
		} else {
			v = new Moto("Yamaha", "" + now.getTime());
		}

		return v;
	}
}
