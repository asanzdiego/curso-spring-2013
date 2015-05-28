package curso.dao.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import curso.modelo.Usuario;

public class MiResultSetExtractor implements ResultSetExtractor {

	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Usuario> lista=
			new ArrayList<Usuario>();
		while(rs.next())
			lista.add(new Usuario(rs.getInt(1),rs.getString(2)));
		return lista;
	}

}
