package com.miempresa.hibernate;
import java.util.List;

public interface PersonDAO {

	public abstract List<Person> list();

	public abstract void save(Person person);

}