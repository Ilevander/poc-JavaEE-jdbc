package com.ilyass.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilyass.school.model.Student;
import com.ilyass.school.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao {

	private static final String INSERT_STUDENT_SQL = "INSERT INTO student" +
	        "  (firstName, lastName, age , email, username, password) VALUES " + " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
	private static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
	private static final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";
	private static final String UPDATE_STUDENT = "UPDATE student SET firstName = ?, lastName = ?, age = ?, email = ?, username = ?, password = ? WHERE id = ?";


	    public StudentDaoImpl() {
	    }

	    @Override
	    public void insertStudent(Student student) throws SQLException {
	        System.out.println(INSERT_STUDENT_SQL);
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
	            preparedStatement.setString(1, student.getFirstName());
	            preparedStatement.setString(2, student.getLastName());
	            preparedStatement.setInt(3, student.getAge());
	            preparedStatement.setString(4, student.getEmail());
	            preparedStatement.setString(5, student.getUsername());
	            preparedStatement.setString(6, student.getPassword());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	            
	         // Retrieve the auto-generated id
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int id = generatedKeys.getInt(1);
	                student.setId(id);
	            }
	            
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	    }

	    @Override
	    public Student selectStudent(int id) {
	        Student student = null;
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                int age = rs.getInt("age");
	                String email = rs.getString("email");
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                student = new Student(id, firstName, lastName, age, email, username, password);
	            }
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	        return student;
	    }

	    @Override
	    public List<Student> selectAllStudents() {
	        List<Student> students = new ArrayList<>();
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
	            System.out.println(preparedStatement);
	            System.out.println("Preparing SQL Querry");
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                int age = rs.getInt("age");
	                String email = rs.getString("email");
	                String username = rs.getString("username");
	                String password = rs.getString("password");
	                students.add(new Student(id, firstName, lastName, age, email, username, password));
	            }
	            System.out.println("Querry passed successfully.");
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	        return students;
	    }

	    @Override
	    public boolean deleteStudent(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_BY_ID)) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }

	    @Override
	    public boolean updateStudent(Student student) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = JDBCUtils.getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT)) {
	            statement.setString(1, student.getFirstName());
	            statement.setString(2, student.getLastName());
	            statement.setInt(3, student.getAge());
	            statement.setString(4, student.getEmail());
	            statement.setString(5, student.getUsername());
	            statement.setString(6, student.getPassword());
	            statement.setInt(7, student.getId());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
}
