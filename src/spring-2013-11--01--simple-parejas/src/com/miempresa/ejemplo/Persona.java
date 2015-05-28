package com.miempresa.ejemplo;

public interface Persona {

	public void setNombre(String nombre);

	public void setEdad(Integer edad);

	public void setPareja(Persona pareja);

	public String getNombre();

	public Integer getEdad();

	public Persona getPareja();
}
