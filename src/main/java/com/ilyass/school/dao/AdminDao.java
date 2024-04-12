package com.ilyass.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ilyass.school.model.Admin;
import com.ilyass.school.utils.JDBCUtils;

public class AdminDao {

    public int registerAdmin(Admin admin) throws ClassNotFoundException {
        String INSERT_ADMINS_SQL = "INSERT INTO admin" +
            "  (username, password) VALUES " +
            " (?, ?);";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
            // Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMINS_SQL)) {
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());

            // Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Process SQL exception
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
}
