package com.ilyass.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ilyass.school.model.LoginBean;
import com.ilyass.school.utils.JDBCUtils;

public class LoginDao { 

	 public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
	        boolean status = false;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = JDBCUtils.getConnection();

	        		PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from admin where username = ? and password = ? ")) {
	            preparedStatement.setString(1, loginBean.getUsername());
	            preparedStatement.setString(2, loginBean.getPassword());

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            status = rs.next();

	        } catch (SQLException e) {
	            // process sql exception
	            JDBCUtils.printSQLException(e);
	        }
	        return status;
	    }
}
