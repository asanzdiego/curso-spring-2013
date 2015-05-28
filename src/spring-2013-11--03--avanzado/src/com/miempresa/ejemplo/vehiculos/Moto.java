package com.miempresa.ejemplo.vehiculos;

public class Moto implements Vehiculo {

	private String marca;

	private String matricula;

	public Moto() {
		super();
		System.out.println("Constructor Moto por defecto");
	}

	public Moto(final String marca, final String matricula) {
		super();
		System.out.println("Constructor Moto con parametros");
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
		return "Esta moto es una " + this.marca;
	}

	@Override
	public String getMatricula() {
		// TODO Auto-generated method stub
		return this.matricula;
	}

	@Override
	public void accelerar() {
		System.out.println("Estoy accelerando la moto");
	}

	@Override
	public String toString() {
		return super.toString() + " Moto [marca=" + this.marca + ", matricula="
				+ this.matricula + "]";
	}

}
