package dao;

import java.util.List;

import entities.Student;

public interface StudentDAO {
	public List<Student> getStudents();
	public boolean insertStudent(Student s);
	public Student getStudentById(String stuId);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(String stuId);
}
