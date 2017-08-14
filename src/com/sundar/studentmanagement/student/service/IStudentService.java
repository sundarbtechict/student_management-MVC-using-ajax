package com.sundar.studentmanagement.student.service;

import java.util.Map;

import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;

public interface IStudentService {
	public  StatusVO createStudent(StudentVO studentVO);
	public  Map<String,Object> getStudentById(String studentId);
	public  StatusVO updateStudent(StudentVO studentVO);
	public  StatusVO deleteStudent(String studentId);
	public  Map<String,Object> getAllStudents();
}
