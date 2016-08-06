package styleapp.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCreateUtils {
	
	public Void setup() throws SQLException
	
	{
		Connection conn = null;

		if (!checkForTable(conn, "USER")) {
			createUserTable(conn);
		}
		if (!checkForTable(conn, "PRODUCT")) {
			createProductTable(conn);
		}

		if (!checkForTable(conn, "USERPRODUCT")) {
			createUserProductTable(conn);
		}

		if (!checkForTable(conn, "USERSTYLE")) {
			createUserStyleTable(conn);
		}
		if (!checkForTable(conn, "STYLECONTENT")) {
			createStyleContentTable(conn);
		}
		
		return null;
	}
	
	private boolean checkForTable(Connection conn,String tableName) {
		boolean exists = false;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT count(*) as count FROM sqlite_master WHERE type='table' AND name= '"
							+ tableName + "'");
			resultSet.next();
			if (resultSet.getInt("count") < 1) {
				exists = false;
			} else {
				exists = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}

	private void createUserTable(Connection conn) throws SQLException {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String query = "CREATE TABLE USER ( USERID INTEGER PRIMARY KEY, LOGONID VARCHAR(100) NOT NULL, PASSWORD VARCHAR(100) NOT NULL, LOYALTYPOINT INTEGER )";
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	private void createProductTable(Connection conn) throws SQLException {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String query = "CREATE TABLE PRODUCT ( PRODUCTID INTEGER PRIMARY KEY, PARTNUMBER VARCHAR(4000) NOT NULL, IMAGEURL VARCHAR(4000) NOT NULL, LIKECOUNT INTEGER )";
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	private void createUserProductTable(Connection conn) throws SQLException {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String query = "CREATE TABLE USERPRODUCT ( USERPRODUCTID INTEGER PRIMARY KEY, USERID INTEGER NOT NULL, PRODUCTID INTEGER NOT NULL, FOREIGN KEY(USERID) REFERENCES USER(USERID), FOREIGN KEY (PRODUCTID) REFERENCES PRODUCT(PRODUCTID) )";
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	private void createUserStyleTable(Connection conn) throws SQLException {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String query = "CREATE TABLE USERSTYLE ( USERSTYLEID INTEGER PRIMARY KEY, USERID INTEGER NOT NULL, STYLENAME VARCHAR(4000) NOT NULL, FOREIGN KEY(USERID) REFERENCES USER(USERID) )";
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	
	private void createStyleContentTable(Connection conn) throws SQLException {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			String query = "CREATE TABLE STYLECONTENT ( CONTENTID INTEGER PRIMARY KEY, USERID INTEGER NOT NULL, USERSTYLEID INTEGER NOT NULL, CONTENT VARCHAR(4000) NOT NULL, FOREIGN KEY(USERID) REFERENCES USER(USERID), FOREIGN KEY(USERSTYLEID) REFERENCES USERSTYLE(USERSTYLEID)  )";
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
}
