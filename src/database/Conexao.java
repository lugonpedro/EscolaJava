package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/cursodb?useTimeZone=true&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "root";
	
	public static Connection conectar() throws Exception {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {
			System.out.println("Erro -> "+e);
			return null;
		}
	}
}