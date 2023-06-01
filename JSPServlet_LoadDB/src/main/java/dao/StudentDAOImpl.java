package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtility;
import entities.Student;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public List<Student> getStudents() {
		List<Student> list = new ArrayList();
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("select * from Student");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setStuId(rs.getString("StuId"));
				s.setFullName(rs.getString("FullName"));
				s.setGender(rs.getBoolean("Gender"));
				s.setBirthday(rs.getDate("Birthday"));
				s.setAddress(rs.getString("Address"));
				s.setClassName(rs.getString("ClassName"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtility.closeConnection(con);
		}
		
		return list;
	}

	@Override
	public boolean insertStudent(Student s) {
		boolean bl = false;
		
		Connection con;
		PreparedStatement pstmt;	
		
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("insert into Student(StuId,FullName,Gender,Birthday,Address,ClassName) values (?,?,?,?,?,?)");
			pstmt.setString(1, s.getStuId());
			pstmt.setString(2, s.getFullName());
			pstmt.setBoolean(3, s.getGender());
			pstmt.setDate(4, new Date(s.getBirthday().getTime())); //chuyen doi ngay tu java.util.Date sang java.sql.Date
			pstmt.setString(5, s.getAddress());
			pstmt.setString(6, s.getClassName());
			
			int i = pstmt.executeUpdate();
			if(i>0)
				bl = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtility.closeConnection(con);
		}
		
		return bl;
	}

	@Override
	public Student getStudentById(String stuId) {
		Student s = null;
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("select * from Student where StuId=?");
			pstmt.setString(1, stuId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				s = new Student();
				s.setStuId(rs.getString("StuId"));
				s.setFullName(rs.getString("FullName"));
				s.setGender(rs.getBoolean("Gender"));
				s.setBirthday(rs.getDate("Birthday"));
				s.setAddress(rs.getString("Address"));
				s.setClassName(rs.getString("ClassName"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtility.closeConnection(con);
		}
		
		return s;
	}
	
	@Override
	public boolean updateStudent(Student s) {
		boolean bl = false;
		
		Connection con;
		PreparedStatement pstmt;	
		
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("update Student set FullName=?, Gender=?, Birthday=?, Address=?, ClassName=? where StuId=?");
			
			pstmt.setString(1, s.getFullName());
			pstmt.setBoolean(2, s.getGender());
			pstmt.setDate(3, new Date(s.getBirthday().getTime())); //chuyen doi ngay tu java.util.Date sang java.sql.Date
			pstmt.setString(4, s.getAddress());
			pstmt.setString(5, s.getClassName());
			pstmt.setString(6, s.getStuId());
			
			int i = pstmt.executeUpdate();
			if(i>0)
				bl = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtility.closeConnection(con);
		}
		
		return bl;
	}

	@Override
	public boolean deleteStudent(String stuId) {
boolean bl = false;
		
		Connection con;
		PreparedStatement pstmt;	
		
		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("delete from Student where StuId=?");
			pstmt.setString(1, stuId);
			
			int i = pstmt.executeUpdate();
			if(i>0)
				bl = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtility.closeConnection(con);
		}
		
		return bl;
	}

}
