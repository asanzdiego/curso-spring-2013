package com.miempresa.mvc;

import java.util.List;

public interface PersonDAO {

	public abstract List<Person> list();

	public abstract Person save(Person person);

	public abstract Person get(Integer personID);

	public abstract Person delete(Integer personID);

}