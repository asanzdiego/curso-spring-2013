package curso.dao.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;

import curso.modelo.Usuario;

public class miRowCallbackHandler implements RowCallbackHandler {
	List<Usuario> lista=
		new ArrayList<Usuario>();
	public void processRow(ResultSet rs) throws SQLException {
		lista.add(new Usuario(rs.getInt(1),rs.getString(2)));

	}

}
