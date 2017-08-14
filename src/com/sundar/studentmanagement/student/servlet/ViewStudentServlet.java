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
 * Servlet implementation class ViewStudentServlet
 */
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId = request.getParameter("studentId");

		
		IStudentService studentService = StudentServiceImpl.getStudentService();
		Map<String, Object> studentVOAndStatusVOMap = studentService.getStudentById(studentId);
		
		
		StudentVO studentVO = (StudentVO) studentVOAndStatusVOMap.get("studentVO");
		StatusVO statusVO = (StatusVO) studentVOAndStatusVOMap.get("statusVO");

		request.setAttribute("studentVO", studentVO);
		request.setAttribute("statusVO", statusVO);

		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/jsp/student/viewStudent.jsp");
		requestDispatcher.forward(request, response);

	}

}
