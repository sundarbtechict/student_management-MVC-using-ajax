package com.sundar.studentmanagement.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private final String url = "jdbc:mysql://localhost:3306/student_management";
	private final String user = "root";
	private final String pass = "";
	private static Connection connection;
	private static DBUtil instance;

	private DBUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
		}
	}

	public static DBUtil getDBUtil() {
		instance = new DBUtil();
		return instance;
	}

	public Connection getConnection() throws Exception {
		return connection;
	}
	
	public static void closeResouces(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
