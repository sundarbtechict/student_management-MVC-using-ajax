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
		// TODO Auto-generated method stub
		String regno = request.getParameter("regno");
		System.out.println(regno);
		StudentServiceImpl s = StudentServiceImpl.getStudentService();
		Map<String, Object> map = s.getStudentById(regno);
		StudentVO studentVO = (StudentVO) map.get("StudentVO");
		StatusVO statusVO = (StatusVO) map.get("StatusVO");
		if (studentVO.isF()) {
			request.setAttribute("student", studentVO);
			request.setAttribute("status", statusVO);
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/student/updateStudent.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentVO st = new StudentVO();
		st.setName(request.getParameter("name"));
		st.setRegNo(request.getParameter("regno"));
		st.setDob(request.getParameter("dob"));
		st.setEmail(request.getParameter("email"));
		st.setMobile(request.getParameter("mobile"));
		st.setDept(request.getParameter("dept"));
		StudentServiceImpl s = StudentServiceImpl.getStudentService();
		StatusVO statusVO = s.updateStudent(st);
		request.setAttribute("status", statusVO);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/getAllStudents");
		rd.forward(request, response);
	}

}
