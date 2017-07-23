package com.sundar.studentmanagement.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sundar.studentmanagement.student.util.DBUtil;
import com.sundar.studentmanagement.student.vo.StatusVO;
import com.sundar.studentmanagement.student.vo.StudentVO;

public class StudentDAOImpl implements IStudentDAO{
	private static StudentDAOImpl studentDAO=new StudentDAOImpl();
	
	private StudentDAOImpl(){}
	
	public static StudentDAOImpl getStudentDAO(){
		return studentDAO;
	}
	public  StatusVO createStudent(StudentVO studentVO)
	{
		StatusVO statusVO=new StatusVO();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			PreparedStatement ps=c.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?)");
			ps.setString(1, studentVO.getRegNo());
			ps.setString(2, studentVO.getName());
			ps.setString(3, studentVO.getDob());
			ps.setString(4, studentVO.getDept());
			ps.setString(5, studentVO.getEmail());
			ps.setString(6, studentVO.getMobile());
			int n=ps.executeUpdate();
			if(n==0)
				System.out.println("record is not inserted");
			else
				{
				System.out.println("record is sucessfully inserted");
				statusVO.setStatusCode("Success");
				statusVO.setStatusMsg("Student record is saved sucessfully");
				}
			ps.close();
			c.close();
			return statusVO;
		}catch (Exception e){
			System.out.println(e);
			statusVO.setStatusCode("Problem");
			statusVO.setStatusMsg("Student record is not saved");
			return statusVO;
		}
	}
	public  Map<String,Object> getStudentById(String regno)
	{
		StatusVO statusVO=new StatusVO();
		StudentVO studentVO=new StudentVO();
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="SELECT * FROM STUDENT WHERE regno=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,regno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				studentVO.setRegNo(rs.getString("regno"));
				studentVO.setName(rs.getString("name"));
				studentVO.setDob(rs.getString("dob"));
				studentVO.setEmail(rs.getString("email"));
				studentVO.setMobile(rs.getString("mobile"));
				studentVO.setDept(rs.getString("dept"));
				studentVO.setF(true);
			}
			statusVO.setStatusCode("*");
			statusVO.setStatusMsg("");
			rs.close();
			ps.close();
			c.close();
			map.put("StudentVO", studentVO);
			map.put("StatusVO", statusVO);
			return map;
			}catch (Exception e){
			statusVO.setStatusCode("Problem");
			statusVO.setStatusMsg("connection not found");
			System.out.println(e); 
			map.put("StatusVO", statusVO);
			return map;
		}
	}
	public  StatusVO updateStudent(StudentVO studentVO)
	{
		StatusVO statusVO = new StatusVO();
	try{
		
		DBUtil dbUtil=DBUtil.getDBUtil();
		Connection c=dbUtil.getConnection();
		PreparedStatement ps=c.prepareStatement("UPDATE STUDENT "
				+ "SET NAME=?,DOB=?,DEPT=?,EMAIL=?,MOBILE=?"
				+ "WHERE REGNO=?");
		ps.setString(6, studentVO.getRegNo());
		ps.setString(1, studentVO.getName());
		ps.setString(2, studentVO.getDob());
		ps.setString(3, studentVO.getDept());
		ps.setString(4, studentVO.getEmail());
		ps.setString(5, studentVO.getMobile());
		int n=ps.executeUpdate();
		if(n==0)
			System.out.println("record is not inserted");
		else{
			System.out.println("record is sucessfully inserted");
			statusVO.setStatusCode("Success");
			statusVO.setStatusMsg("Student record is updated sucessfully");
		}
		ps.close();
		c.close();
		return statusVO;
	}catch (Exception e){
		System.out.println(e);
		statusVO.setStatusCode("Problem");
		statusVO.setStatusMsg("Student record is not updated ");
		return statusVO;
		}
	}
	public  StatusVO deleteStudent(String regno) 
	{
		StatusVO statusVO = new StatusVO();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="DELETE FROM STUDENT WHERE regno=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,regno);
			ps.executeUpdate();
			ps.close();
			c.close();
			statusVO.setStatusCode("Success");
			statusVO.setStatusMsg("Student record is deleted sucessfully");
			return statusVO;
		}catch (Exception e){
			System.out.println(e);
			statusVO.setStatusCode("Problem");
			statusVO.setStatusMsg("Student record is not deleted ");
			return statusVO;
			}
	}
	public Map<String,Object> getAllStudents() 
	{
		StatusVO statusVO=new StatusVO();
		Map<String,Object> map=new HashMap<String, Object>();
		List<StudentVO> list=new ArrayList<StudentVO>();
		try{
		DBUtil dbUtil=DBUtil.getDBUtil();
		Connection c=dbUtil.getConnection();
		String sql="SELECT * FROM STUDENT";
		PreparedStatement ps=c.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			StudentVO studentVO=new StudentVO();
			studentVO.setRegNo(rs.getString("regno"));
			studentVO.setName(rs.getString("name"));
			studentVO.setDob(rs.getString("dob"));
			studentVO.setDept(rs.getString("dept"));
			studentVO.setEmail(rs.getString("email"));
			studentVO.setMobile(rs.getString("mobile"));
			list.add(studentVO);
		}
		statusVO.setStatusCode("*");
		statusVO.setStatusMsg("");
		rs.close();
		ps.close();
		c.close();
		map.put("StudentList", list);
		map.put("StatusVO", statusVO);
		return map;
		}catch (Exception e)
		{
			statusVO.setStatusCode("Problem");
			statusVO.setStatusMsg("connection not found");
			System.out.println(e); 
			map.put("StatusVO", statusVO);
			return map;
		}
	}
}
