package styleapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DataBaseUtils {

	/***
	 * logger Logger.
	 */

	/**
	 * Singleton instance.
	 */
	private static DataBaseUtils instance = new DataBaseUtils();

	/**
	 * private default constructor.
	 */
	private DataBaseUtils() {
	};

	/**
	 * This method returns the singleton instance for this class.
	 * 
	 * @return instance SonarUtils.
	 */
	public static DataBaseUtils getInstance() {
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:saurav.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * closeConnection conn.
	 * 
	 * @param conn
	 */
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
