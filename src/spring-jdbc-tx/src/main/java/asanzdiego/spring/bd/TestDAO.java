package asanzdiego.spring.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public void insertTests() {

		this.insertTest(11, "once");
		this.insertTest(null, "doce");
	}
	
	@Transactional
	public void deleteTests() {

		final int updatedRows = this.jdbcTemplate.update("DELETE FROM TEST");
		System.out.println("deletedRows=" + updatedRows);
	}

	@Transactional
	public void insertTest(final Integer id, final String name) {

		final int updatedRows = this.jdbcTemplate.update(
				"INSERT INTO TEST VALUES(?, ?)", id, name);
		System.out.println("updatedRows=" + updatedRows);
	}

	public void printTestList() {

		final List<Test> rows = this.jdbcTemplate.query(
				"SELECT id, name FROM test", new RowMapper<Test>() {

					public Test mapRow(final ResultSet result, final int rowNum)
							throws SQLException {

						final Test row = new Test();
						row.setId(result.getInt("id"));
						row.setName(result.getString("name"));
						return row;
					}
				});

		for (final Test test : rows) {
			System.out.println(test);
		}
	}
}
