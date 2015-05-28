package com.miempresa.jdbc;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonaService implements IPersonaService {

	private IPersonaDAO personaDAO;

	public void setPersonaDAO(final IPersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IPersonaService#deletePersonas()
	 */
	@Override
	public void deletePersonas() {
		this.personaDAO.deletePersonas();
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see IPersonaService#insertPersona()
	 */
	@Override
	public void insertPersona(final String nombre) {
		this.personaDAO.insertPersona(nombre);
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see IPersonaService#insertPersonas()
	 */
	@Override
	public void insertPersonas() {
		this.insertPersona("pepito");
		this.insertPersona(null);
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see IPersonaService#selectPersonas()
	 */
	@Override
	public void selectPersonas() {
		this.personaDAO.selectPersonas();
	};
}
