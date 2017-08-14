package com.sundar.studentmanagement.student.service;

import java.util.Map;

import com.sundar.studentmanagement.student.dao.IStudentDAO;
import com.sundar.studentmanagement.student.dao.StudentDAOImpl;
import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;

public class StudentServiceImpl implements IStudentService{
	
	// Singleton -Pattern
	private static StudentServiceImpl instance = new StudentServiceImpl();
	private StudentServiceImpl(){}
	public static StudentServiceImpl getInstance() {
		return instance;
	}



	public  StatusVO createStudent(StudentVO studentVO)
	{
		IStudentDAO studentDAO=StudentDAOImpl.getInstance();
		StatusVO statusVO=studentDAO.createStudent(studentVO);
		return statusVO;
	}
	public  Map<String,Object> getStudentById(String studentId)
	{
		IStudentDAO studentDAO=StudentDAOImpl.getInstance();
		Map<String,Object> map=studentDAO.getStudentById(studentId);
		return map;
		
	}
	public  StatusVO updateStudent(StudentVO studentVO){
		IStudentDAO studentDAO=StudentDAOImpl.getInstance();
		StatusVO statusVO=studentDAO.updateStudent(studentVO);
		return statusVO;
	}
	public  StatusVO deleteStudent(String studentId){
		IStudentDAO studentDAO=StudentDAOImpl.getInstance();
		StatusVO statusVO=studentDAO.deleteStudent(studentId);
		return statusVO;
	}
	public  Map<String,Object> getAllStudents(){
		IStudentDAO studentDAO=StudentDAOImpl.getInstance();
		Map<String,Object> map=studentDAO.getAllStudents();
		return map;
	}
}
