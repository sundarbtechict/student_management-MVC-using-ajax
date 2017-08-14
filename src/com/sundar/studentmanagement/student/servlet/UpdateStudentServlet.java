package com.sundar.studentmanagement.student.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;
import com.sundar.studentmanagement.student.service.IStudentService;
import com.sundar.studentmanagement.student.service.StudentServiceImpl;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String studentId = request.getParameter("studentId");
		
		IStudentService studentService = StudentServiceImpl.getInstance();
		Map<String, Object> studentVOAndStatusVOMap = studentService.getStudentById(studentId);
		
		
		StudentVO studentVO = (StudentVO) studentVOAndStatusVOMap.get("studentVO");
		StatusVO statusVO = (StatusVO) studentVOAndStatusVOMap.get("statusVO");
	
		request.setAttribute("studentVO", studentVO);
		request.setAttribute("statusVO", statusVO);
	
		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/jsp/student/updateStudent.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentVO studentVO = new StudentVO();
		studentVO.setName(request.getParameter("name"));
		studentVO.setStudentId(request.getParameter("studentId"));
		studentVO.setDob(request.getParameter("dob"));
		studentVO.setEmail(request.getParameter("email"));
		studentVO.setMobile(request.getParameter("mobile"));
		studentVO.setDept(request.getParameter("dept"));
		studentVO.setRegNo(request.getParameter("regNo"));
		
		
		IStudentService studentService = StudentServiceImpl.getInstance();
		StatusVO statusVO = studentService.updateStudent(studentVO);
		request.setAttribute("statusVO", statusVO);
		
		
		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/getAllStudents");
		requestDispatcher.forward(request, response);
	}

}
