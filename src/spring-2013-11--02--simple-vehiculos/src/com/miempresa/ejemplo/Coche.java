package com.miempresa.ejemplo;

public class Coche implements Vehiculo {

	private String marca;

	private String matricula;

	public Coche() {
		super();
		System.out.println("Constructor por defecto");
	}

	public Coche(final String marca, final String matricula) {
		super();
		System.out.println("Constructor con parametros");
		this.marca = marca;
		this.matricula = matricula;
	}

	@Override
	public void setMarca(final String marca) {
		this.marca = marca;
	}

	@Override
	public void setMatricula(final String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return "Este coche es un " + this.marca;
	}

	@Override
	public String getMatricula() {
		// TODO Auto-generated method stub
		return this.matricula;
	}

	@Override
	public void accelerar() {
		System.out.println("Estoy accelerando el coche");
	}

}
