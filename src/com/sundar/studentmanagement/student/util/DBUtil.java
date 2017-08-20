package com.sundar.studentmanagement.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sundar.studentmanagement.student.servlet.GetAllStudentsServlet;

public class DBUtil {
	private static final Logger LOGGER = Logger.getLogger(DBUtil.class);

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_HOST = "jdbc:mysql://localhost:3306/student_management";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";

	public static Connection getConnection() throws Exception {

		Connection connection = null;
		Class.forName(DB_DRIVER);
		connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);

		LOGGER.info("-----------------getConnection :: SUCESS---------------------");
		return connection;
	}

	public static void closeResouces(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

		if (resultSet != null) {
			try {
				resultSet.close();
				LOGGER.info("-----------------closeResouces:resultSet :: SUCESS---------------------");
			} catch (SQLException e1) {

				LOGGER.error("-----------------closeResouces:resultSet :: FAILURE---------------------");

				e1.printStackTrace();
			}
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
				LOGGER.info("-----------------closeResouces:preparedStatement :: SUCESS---------------------");
			} catch (SQLException e) {
				LOGGER.error("-----------------closeResouces:preparedStatement :: FAILURE---------------------");

				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
				LOGGER.info("-----------------closeResouces:connection :: SUCESS---------------------");
			} catch (SQLException e) {
				LOGGER.error("-----------------closeResouces:connection :: FAILURE---------------------");

				e.printStackTrace();
			}
		}

	}
}
