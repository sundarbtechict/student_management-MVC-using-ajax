package com.sundar.studentmanagement.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_HOST = "jdbc:mysql://localhost:3306/student_management";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";

	public static Connection getConnection() throws Exception {
		Connection connection = null;
		Class.forName(DB_DRIVER);
		connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
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
