package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String usuario = "postgres";
	private static String senha = "Abc123****";
	private static Connection connection = null;

	public static Connection getConnection () {
		return connection;
	}
	
	static {
		conectar();
	}
	
	public SingleConnectionBanco() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, usuario, senha);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
