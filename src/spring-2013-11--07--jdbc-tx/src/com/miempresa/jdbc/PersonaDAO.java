package com.miempresa.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PersonaDAO implements IPersonaDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void deletePersonas() {
		final int updatedRows = this.jdbcTemplate
				.update("DELETE FROM PERSONAS");
		System.out.println("deletedRows=" + updatedRows);
	}

	@Override
	public void insertPersona(final String nombre) {
		final int updatedRows = this.jdbcTemplate.update(
				"INSERT INTO PERSONAS VALUES(?)", new Object[] { nombre });
		System.out.println("updatedRows=" + updatedRows);
	}

	@Override
	public void selectPersonas() {
		final List<String> rows = this.jdbcTemplate.query(
				"SELECT * FROM personas", new RowMapper() {

					@Override
					public String mapRow(final ResultSet result,
							final int rowNum) throws SQLException {
						return result.getString("nombre");
					}
				});

		for (final String nombre : rows) {
			System.out.println(nombre);
		}

	}
}
