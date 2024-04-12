package com.ilyass.school.dao;

import java.sql.SQLException;
import java.util.List;

import com.ilyass.school.model.Student;

public interface StudentDao {

	void insertStudent(Student student) throws SQLException;

    Student selectStudent(int id);

    List<Student> selectAllStudents();

    boolean deleteStudent(int id) throws SQLException;

    boolean updateStudent(Student student) throws SQLException;
}
