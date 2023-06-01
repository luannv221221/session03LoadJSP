package dao;

import java.sql.Connection;
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

}
