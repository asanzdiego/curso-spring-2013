package com.miempresa.ejemplo.aop.proxy;

public class Mujer implements Persona {
	private String nombre;
	private Integer edad;
	private Persona pareja;

	@Override
	public String getNombre() {
		return "Esta mujer se llama " + this.nombre;
	}

	@Override
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Integer getEdad() {
		return this.edad;
	}

	@Override
	public void setEdad(final Integer edad) {
		this.edad = edad;
	}

	@Override
	public Persona getPareja() {
		return this.pareja;
	}

	@Override
	public void setPareja(final Persona pareja) {
		this.pareja = pareja;
	}

	@Override
	public String toString() {
		String nombrePareja = "--";
		if (this.pareja != null) {
			nombrePareja = this.pareja.getNombre();
		}
		return "Mujer [nombre=" + this.nombre + ", edad=" + this.edad
				+ ", pareja=" + nombrePareja + "]";
	}

}
