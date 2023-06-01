package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAOImpl;
import entities.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String stuId = request.getParameter("stuId");
		String fullName = request.getParameter("fullName");
		String strGender = request.getParameter("gender");
		String strBirthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String className = request.getParameter("className");
		
		Boolean gender = Boolean.parseBoolean(strGender);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sf.parse(strBirthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Student s = new Student();
		s.setStuId(stuId);
		s.setFullName(fullName);
		s.setGender(gender);
		s.setBirthday(birthday);
		s.setAddress(address);
		s.setClassName(className);
		
		boolean bl = new StudentDAOImpl().updateStudent(s);
		if(bl) {
			response.sendRedirect("LoadStudents");
		}else {
			request.setAttribute("err", "Update failed!");
			request.setAttribute("s", s);
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
