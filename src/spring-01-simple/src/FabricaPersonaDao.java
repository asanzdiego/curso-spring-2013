import javax.sql.DataSource;

public class FabricaPersonaDao {

  //private static FabricaPersonaDao instance;

  private DataSource dataSource;

  /*static {
    instance = new FabricaPersonaDao();
  }*/

  private FabricaPersonaDao() {

	  System.out.println("FabricaPersonaDao");
  }

  /*private FabricaPersonaDao getInstance() {
	  
	  System.out.println("getInstance");

    return new FabricaPersonaDao();
  }*/

  public PersonaDao getDao() {
  
    return new PersonaDaoMysqlImpl(this.dataSource);
  }

  public DataSource getDataSource() {
  
    return this.dataSource;
  }

  public void setDataSource(final DataSource dataSource) {
  
    this.dataSource = dataSource;
  }

}
