

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class PersonaDaoMysqlImpl implements PersonaDao {
	
	private DataSource ds;

	public PersonaDaoMysqlImpl(DataSource ds) {
		super();
		this.ds = ds;
	}

	public PersonaDaoMysqlImpl() {
		
	}
	
	@Override
	public void borrar(Persona p) {
		Connection cn = null;
		try {
			cn = ds.getConnection();
			PreparedStatement pst = 
				cn.prepareStatement("delete from personas where nombre=?");
			pst.setString(1, p.getNombre());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Persona buscar(String n) {
		QueryRunner qr=new QueryRunner(ds);
		BeanHandler bh=new BeanHandler(Persona.class);
		try {
			return (Persona) 
				qr.query("select * from personas where nombre=?",n, bh);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void guardar(Persona p) {
		QueryRunner qr=new QueryRunner(ds);
		try {
			qr.update("insert into personas values(?,?,?,?)",
					new Object[]{p.getNombre(),p.getEdad(),p.getAltura(),p.getFecha()});
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Persona> listar() {
		QueryRunner qr=new QueryRunner(ds);
		BeanListHandler blh=new BeanListHandler(Persona.class);
		try {
			return 
				(List<Persona>) qr.query("select * from personas", blh);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

}
