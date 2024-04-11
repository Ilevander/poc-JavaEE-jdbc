package com.ilyass.school.dao;

import java.sql.SQLException;
import java.util.List;

import com.ilyass.school.model.Teacher;

public interface TeacherDao {

	void insertTeacher(Teacher teacher) throws SQLException;

    Teacher selectTeacher(int id);

    List<Teacher> selectAllTeachers();

    boolean deleteTeacher(int id) throws SQLException;

    boolean updateTeacher(Teacher teacher) throws SQLException;
}
