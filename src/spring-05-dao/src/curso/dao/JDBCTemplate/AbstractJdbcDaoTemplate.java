package curso.dao.JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import curso.dao.UsuarioDao;

public class AbstractJdbcDaoTemplate {

	protected JdbcTemplate jt;

	public AbstractJdbcDaoTemplate() {
		super();
	}

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

}