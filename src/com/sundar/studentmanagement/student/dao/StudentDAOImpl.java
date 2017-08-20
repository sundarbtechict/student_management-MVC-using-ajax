package com.sundar.studentmanagement.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sundar.studentmanagement.student.constants.CommonConstants;
import com.sundar.studentmanagement.student.servlet.GetAllStudentsServlet;
import com.sundar.studentmanagement.student.util.DBUtil;
import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;

public class StudentDAOImpl implements IStudentDAO {
	private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);

	// Singleton -Pattern
	private static StudentDAOImpl instance = new StudentDAOImpl();

	private StudentDAOImpl() {
	}

	public static StudentDAOImpl getInstance() {
		return instance;
	}

	public StatusVO createStudent(StudentVO studentVO) {
		LOGGER.info("-----------------createStudent---------------------");

		StatusVO statusVO = new StatusVO();
		String sql = "INSERT INTO STUDENT (NAME, DOB, DEPT, EMAIL, MOBILE, REG_NO) VALUES(?,?,?,?,?,?)";
		try {
			// DBUtil dbUtil = DBUtil.getInstance();
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studentVO.getName());
			preparedStatement.setString(2, studentVO.getDob());
			preparedStatement.setString(3, studentVO.getDept());
			preparedStatement.setString(4, studentVO.getEmail());
			preparedStatement.setString(5, studentVO.getMobile());
			preparedStatement.setString(6, studentVO.getRegNo());
			int noOfRecordsInserted = preparedStatement.executeUpdate();
			if (noOfRecordsInserted > 0) {
				// System.out.println("record is successfully inserted");
				statusVO.setStatusCode(CommonConstants.STATUS_CODE_SUCCESS);
				statusVO.setStatusMsg("Student is Created Sucessfully");
			} else {
				// System.out.println("record is not inserted");
				statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
				statusVO.setStatusMsg("Student is not Created");
				statusVO.setMoreDetails("No Error occured in DB, But noOfRecordsInserted is 0");
			}

			LOGGER.info("-----------------createStudent :: SUCCESS---------------------");
			DBUtil.closeResouces(connection, preparedStatement, null);

		} catch (Exception e) {
			LOGGER.error("-----------------createStudent :: FAILURE---------------------");
			e.printStackTrace();

			statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
			statusVO.setStatusMsg("Student record is not saved");
			statusVO.setMoreDetails("Exception occured in DB while saving the Student record");
		}

		return statusVO;
	}

	public Map<String, Object> getStudentById(String studentId) {
		LOGGER.info("-----------------getStudentById ---------------------");

		String sql = "SELECT STUDENT_ID,NAME,DOB,EMAIL,MOBILE,DEPT,REG_NO FROM STUDENT WHERE STUDENT_ID=?";

		StatusVO statusVO = new StatusVO();
		StudentVO studentVO = null;
		Map<String, Object> studentVOAndStatusVOMap = new HashMap<String, Object>();
		try {
			// DBUtil dbUtil = DBUtil.getInstance();
			Connection connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				studentVO = new StudentVO();
				studentVO.setStudentId(resultSet.getString("STUDENT_ID"));
				studentVO.setName(resultSet.getString("NAME"));
				studentVO.setDob(resultSet.getString("DOB"));
				studentVO.setEmail(resultSet.getString("EMAIL"));
				studentVO.setMobile(resultSet.getString("MOBILE"));
				studentVO.setDept(resultSet.getString("DEPT"));
				studentVO.setRegNo(resultSet.getString("REG_NO"));
			}

			LOGGER.info("-----------------getStudentById :: SUCCESS---------------------");
			DBUtil.closeResouces(connection, preparedStatement, resultSet);
			studentVOAndStatusVOMap.put("studentVO", studentVO);

		} catch (Exception e) {
			LOGGER.error("-----------------getStudentById :: FAILURE---------------------");
			e.printStackTrace();

			statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
			statusVO.setStatusMsg("Failed to get student record by Student Id");
			statusVO.setMoreDetails("Exception occured in DB while getting the Student record by Id");
			studentVOAndStatusVOMap.put("statusVO", statusVO);
		}

		return studentVOAndStatusVOMap;
	}

	public StatusVO updateStudent(StudentVO studentVO) {
		LOGGER.info("-----------------updateStudent---------------------");

		String sql = "UPDATE STUDENT SET NAME=?,DOB=?,DEPT=?,EMAIL=?,MOBILE=?, REG_NO=? WHERE STUDENT_ID=?";
		StatusVO statusVO = new StatusVO();
		try {

			// DBUtil dbUtil = DBUtil.getInstance();
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, studentVO.getName());
			preparedStatement.setString(2, studentVO.getDob());
			preparedStatement.setString(3, studentVO.getDept());
			preparedStatement.setString(4, studentVO.getEmail());
			preparedStatement.setString(5, studentVO.getMobile());
			preparedStatement.setString(6, studentVO.getRegNo());
			preparedStatement.setString(7, studentVO.getStudentId());

			int noOfRecordsInserted = preparedStatement.executeUpdate();

			if (noOfRecordsInserted > 0) {
				// System.out.println("record is successfully inserted");
				statusVO.setStatusCode(CommonConstants.STATUS_CODE_SUCCESS);
				statusVO.setStatusMsg("Student record is updated sucessfully");
			} else {
				// System.out.println("record is not inserted");
				statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
				statusVO.setStatusMsg("Student record is not updated");
				statusVO.setMoreDetails("No Error occured in DB, But noOfRecordsInserted is 0");
			}

			LOGGER.info("-----------------updateStudent :: SUCCESS---------------------");
			DBUtil.closeResouces(connection, preparedStatement, null);

		} catch (Exception e) {
			LOGGER.error("-----------------updateStudent :: FAILURE---------------------");
			e.printStackTrace();

			statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
			statusVO.setStatusMsg("Student record is not updated");
			statusVO.setMoreDetails("Exception occured in DB while updaing the Student record");

		}

		return statusVO;
	}

	public StatusVO deleteStudent(String studentId) {

		LOGGER.info("-----------------deleteStudent---------------------");

		String sql = "DELETE FROM STUDENT WHERE STUDENT_ID=?";
		StatusVO statusVO = new StatusVO();

		try {
			// DBUtil dbUtil = DBUtil.getInstance();
			Connection connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, studentId);

			int noOfRecordsInserted = preparedStatement.executeUpdate();

			if (noOfRecordsInserted > 0) {
				// System.out.println("record is successfully inserted");
				statusVO.setStatusCode(CommonConstants.STATUS_CODE_SUCCESS);
				statusVO.setStatusMsg("Student record is deleted sucessfully");
			} else {
				// System.out.println("record is not inserted");
				statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
				statusVO.setStatusMsg("Student record is not deleted");
				statusVO.setMoreDetails("No Error occured in DB, But noOfRecordsInserted is 0");
			}

			LOGGER.info("-----------------deleteStudent :: SUCCESS---------------------");
			DBUtil.closeResouces(connection, preparedStatement, null);

		} catch (Exception e) {
			LOGGER.error("-----------------deleteStudent :: FAILURE---------------------");
			e.printStackTrace();
			statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
			statusVO.setStatusMsg("Student record is not deleted");
			statusVO.setMoreDetails("Exception occured in DB while deleting the Student record");
		}

		return statusVO;
	}

	public Map<String, Object> getAllStudents() {
		LOGGER.info("-----------------getAllStudents---------------------");

		String sql = "SELECT STUDENT_ID,NAME,DOB,DEPT,EMAIL,MOBILE,REG_NO FROM STUDENT";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		StatusVO statusVO = new StatusVO();
		Map<String, Object> studentVOAndStatusVOMap = new HashMap<String, Object>();
		List<StudentVO> studentVOs = null;

		try {
			// DBUtil dbUtil = DBUtil.getInstance();
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			studentVOs = new ArrayList<StudentVO>();
			while (resultSet.next()) {
				StudentVO studentVO = new StudentVO();
				studentVO.setStudentId(resultSet.getString("STUDENT_ID"));
				studentVO.setName(resultSet.getString("NAME"));
				studentVO.setDob(resultSet.getString("DOB"));
				studentVO.setDept(resultSet.getString("DEPT"));
				studentVO.setEmail(resultSet.getString("EMAIL"));
				studentVO.setMobile(resultSet.getString("MOBILE"));
				studentVO.setRegNo(resultSet.getString("REG_NO"));
				studentVOs.add(studentVO);
			}

			LOGGER.info("-----------------getAllStudents :: SUCCESS---------------------");
			DBUtil.closeResouces(connection, preparedStatement, resultSet);
			studentVOAndStatusVOMap.put("studentVOs", studentVOs);

		} catch (Exception e) {
			LOGGER.error("-----------------getAllStudents :: FAILURE---------------------");

			e.printStackTrace();
			statusVO = new StatusVO();
			statusVO.setStatusCode(CommonConstants.STATUS_CODE_FAILURE);
			statusVO.setStatusMsg("Failed to get student records");
			statusVO.setMoreDetails("Exception occured in DB while getting the Student records");
			studentVOAndStatusVOMap.put("statusVO", statusVO);

			DBUtil.closeResouces(connection, preparedStatement, resultSet);
		}

		return studentVOAndStatusVOMap;
	}
}
