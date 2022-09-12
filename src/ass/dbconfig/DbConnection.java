/*
 * @author KhoiHT2
 * @date 6 thg 9, 2022
 * @version 1.0
 */



package ass.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection {
	
	  static DbConnection instance;
	  private Connection connection;

	  public DbConnection() {
	    try {
	      String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	      
	      String url = "jdbc:sqlserver://localhost:1433;databaseName=CandidateManagement";
	      String user = "sa";
	      String pass = "123456";
	      Class.forName(driver);
	      connection = DriverManager.getConnection(url, user, pass);

	    } catch (SQLException | ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	  }

	  public Connection getConnection() {
	    return connection;
	  }

	  public static DbConnection getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new DbConnection();
	    } else if (instance.getConnection().isClosed())
	      instance = new DbConnection();
	    return instance;
	  }
	  
	  
//	public static void main(String[] args) {
//		DbConnection dbconn = new DbConnection();
//		dbconn.getConnection();
//	}  
	  
	  

}
