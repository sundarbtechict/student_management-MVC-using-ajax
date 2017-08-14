package com.sundar.studentmanagement.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 * Servlet implementation class IndexStudentServlet
 */
public class GetAllModulesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllModulesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		IStudentService studentService = StudentServiceImpl.getInstance();
		Map<String, Object> studentVOAndStatusVOMap = studentService.getAllStudents();
		@SuppressWarnings("unchecked")
		List<StudentVO> studentVOs = (List<StudentVO>) studentVOAndStatusVOMap.get("studentVOs");
		StatusVO statusVO = (StatusVO) studentVOAndStatusVOMap.get("statusVO");
		
		
		request.setAttribute("studentVOs", studentVOs);
		request.setAttribute("statusVO", statusVO);
		
		
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/common/getAllModules.jsp");
		rd.forward(request, response);
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
