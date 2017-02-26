package com.comman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DbHelper.
 */
public class DbHelper {

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Connection getConnection() throws SQLException {

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/wordpress?verifyServerCertificate=false&useSSL=true", "root", "root");
		return con;
	}
}
