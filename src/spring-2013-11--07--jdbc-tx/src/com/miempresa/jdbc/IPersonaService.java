package com.miempresa.jdbc;

public interface IPersonaService {

	public abstract void deletePersonas();

	public abstract void insertPersonas();

	public abstract void selectPersonas();

	public void insertPersona(String nombre);

}