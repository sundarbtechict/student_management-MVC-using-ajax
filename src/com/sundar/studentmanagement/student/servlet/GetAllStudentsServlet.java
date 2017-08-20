package com.sundar.studentmanagement.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;
import com.sundar.studentmanagement.student.service.IStudentService;
import com.sundar.studentmanagement.student.service.StudentServiceImpl;
import com.sundar.studentmanagement.student.util.CommonUtil;

/**
 * Servlet implementation class IndexStudentServlet
 */
public class GetAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(GetAllStudentsServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllStudentsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("-----------------getAllStudents---------------------");
		
		IStudentService studentService = StudentServiceImpl.getInstance();
		Map<String, Object> studentVOAndStatusVOMap = studentService.getAllStudents();

		
		@SuppressWarnings("unchecked")
		List<StudentVO> studentVOs = (List<StudentVO>) studentVOAndStatusVOMap.get("studentVOs");
		StatusVO statusVO = (StatusVO) studentVOAndStatusVOMap.get("statusVO");
		request.setAttribute("studentVOs", studentVOs);
		
		
		if (CommonUtil.isForwardedRequest(request)) {
			StatusVO oldStatusVO = (StatusVO)request.getAttribute("statusVO");
			List<StatusVO> statusVOs = new ArrayList<StatusVO>();
			statusVOs.add(oldStatusVO);
			
			if (statusVO != null) {
				statusVOs.add(statusVO);
			}
			
			request.setAttribute("statusVOs", statusVOs);
		}

		ServletContext context = getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/jsp/student/getAllStudents.jsp");
		requestDispatcher.forward(request, response);
		
		LOGGER.info("-----------------/getAllStudents---------------------");
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
