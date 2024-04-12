package com.ilyass.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilyass.school.model.Teacher;
import com.ilyass.school.utils.JDBCUtils;

public class TeacherDaoImpl implements TeacherDao {

	private static final String INSERT_TEACHER_SQL = "INSERT INTO teacher" +
	        "  (firstName, lastName, subject, email, username, password) VALUES " + " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_TEACHER_BY_ID = "SELECT * FROM teacher WHERE id = ?";
	private static final String SELECT_ALL_TEACHERS = "SELECT * FROM teacher";
	private static final String DELETE_TEACHER_BY_ID = "DELETE FROM teacher WHERE id = ?";
	private static final String UPDATE_TEACHER = "UPDATE teacher SET firstName = ?, lastName = ?, subject = ?, email = ?, username = ?, password = ? WHERE id = ?";


	    public TeacherDaoImpl() {
	    }

	    @Override
	    public void insertTeacher(Teacher teacher) throws SQLException {
	        System.out.println(INSERT_TEACHER_SQL);
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER_SQL)) {
	            preparedStatement.setString(1, teacher.getFirstName());
	            preparedStatement.setString(2, teacher.getLastName());
	            preparedStatement.setString(3, teacher.getSubject());
	            preparedStatement.setString(4, teacher.getEmail());
	            preparedStatement.setString(5, teacher.getUsername());
	            preparedStatement.setString(6, teacher.getPassword());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	            
	         // Retrieve the auto-generated id
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int id = generatedKeys.getInt(1);
	                teacher.setId(id);
	            }
	            
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	    }

	    @Override
	    public Teacher selectTeacher(int id) {
	        Teacher teacher = null;
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_BY_ID)) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                String subject = rs.getString("subject");
	                String email = rs.getString("email");
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                teacher = new Teacher(id, firstName, lastName, subject, email, username, password);
	            }
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	        return teacher;
	    }

	    @Override
	    public List<Teacher> selectAllTeachers() {
	        List<Teacher> teachers = new ArrayList<>();
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS)) {
	            System.out.println(preparedStatement);
	            System.out.println("toto");
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                String subject = rs.getString("subject");
	                String email = rs.getString("email");
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                teachers.add(new Teacher(id, firstName, lastName, subject, email, username, password));
	            }
	            System.out.println("done");
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	        return teachers;
	    }

	    @Override
	    public boolean deleteTeacher(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_TEACHER_BY_ID)) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    @Override
	    public boolean updateTeacher(Teacher teacher) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHER)) {
	            statement.setString(1, teacher.getFirstName());
	            statement.setString(2, teacher.getLastName());
	            statement.setString(3, teacher.getSubject());
	            statement.setString(4, teacher.getEmail());
	            statement.setString(5, teacher.getUsername());
	            statement.setString(6, teacher.getPassword());
	            statement.setInt(7, teacher.getId());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
}
