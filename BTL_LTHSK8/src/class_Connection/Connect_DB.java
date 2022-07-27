package class_Connection;

import java.sql.DriverManager;

import java.sql.Connection;

public class Connect_DB {
	public static Connection con = null;
	private static Connect_DB instance = new Connect_DB();
	public static Connect_DB getInstance() {
		return instance;
	}
	public static void connect() {
		try {
			String url ="jdbc:sqlserver://localhost:1433;databasename=QLQT" ;
			String user = "sa";
			String password = "sapassword";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection  getConnection() {
		return con;
	}
}
