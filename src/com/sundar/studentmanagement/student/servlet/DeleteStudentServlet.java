package com.sundar.studentmanagement.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sundar.studentmanagement.student.service.IStudentService;
import com.sundar.studentmanagement.student.service.StudentServiceImpl;
import com.sundar.studentmanagement.student.vo.StatusVO;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStudentServlet() {
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
		IStudentService studentService = StudentServiceImpl.getStudentService();
		StatusVO statusVO = studentService.deleteStudent(studentId);
		request.setAttribute("statusVO", statusVO);
		
		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/getAllStudents");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
