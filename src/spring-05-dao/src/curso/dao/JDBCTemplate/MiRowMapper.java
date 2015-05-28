package curso.dao.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import curso.modelo.Usuario;

public class MiRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int n) throws SQLException {
		
		return new Usuario(rs.getInt(1),rs.getString(2));
	}

}
