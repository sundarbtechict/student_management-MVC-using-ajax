package com.sundar.studentmanagement.student.service;

import java.util.Map;

import com.sundar.studentmanagement.student.dao.StudentDAOImpl;
import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;

public class StudentServiceImpl implements IStudentService{
	private static StudentServiceImpl studentService=new StudentServiceImpl();
	
	private StudentServiceImpl(){}
	
	public static StudentServiceImpl getStudentService(){
		return studentService;
	}
	

	public  StatusVO createStudent(StudentVO studentVO)
	{
		StudentDAOImpl studentDAO=StudentDAOImpl.getStudentDAO();
		StatusVO statusVO=studentDAO.createStudent(studentVO);
		return statusVO;
	}
	public  Map<String,Object> getStudentById(String regno)
	{
		StudentDAOImpl studentDAO=StudentDAOImpl.getStudentDAO();
		Map<String,Object> map=studentDAO.getStudentById(regno);
		return map;
		
	}
	public  StatusVO updateStudent(StudentVO studentVO){
		StudentDAOImpl studentDAO=StudentDAOImpl.getStudentDAO();
		StatusVO statusVO=studentDAO.updateStudent(studentVO);
		return statusVO;
	}
	public  StatusVO deleteStudent(String regno){
		StudentDAOImpl studentDAO=StudentDAOImpl.getStudentDAO();
		StatusVO statusVO=studentDAO.deleteStudent(regno);
		return statusVO;
	}
	public  Map<String,Object> getAllStudents(){
		StudentDAOImpl studentDAO=StudentDAOImpl.getStudentDAO();
		Map<String,Object> map=studentDAO.getAllStudents();
		return map;
	}
}
