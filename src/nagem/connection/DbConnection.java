package nagem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public Connection getConnections() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/nagem", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException("erro ao conectar ao banco", e);
		}
	}

}
