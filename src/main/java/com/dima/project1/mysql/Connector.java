package com.dima.project1.mysql;

import lombok.Getter;

import java.sql.*;

/**
 * This class sets connection with program and MySQL database with JDBC
 */
public class Connector {

    /**
     * Connection class object to communicate between program and database
     */
    private Connection connection;

    // using prepared statements to avoid situation that user can write invalid request that can damage database
    /**
     * Prepared statement for handling login request
     */
    @Getter
    private PreparedStatement preparedStatementLogin;

    /**
     * Prepared statement for handling confirming registration request
     */
    @Getter
    private PreparedStatement preparedStatementConfirm;

    /**
     * Prepared statement for handling request if the user is already in database
     */
    @Getter
    private PreparedStatement preparedStatementCheckUser;

    /**
     * Method that connects our program and MySQL database with JDBC, initializes preparedStatements and other fields
     * @throws SQLException exception that could be thrown in process
     */
    public void connect() throws SQLException{
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", "root", "root12345");
            preparedStatementLogin = connection.prepareStatement("select * from users where login = ? and pass = ?;");
            preparedStatementConfirm = connection.prepareStatement("insert into users(login, pass, visits) values(?, ?, 0);");
            preparedStatementCheckUser = connection.prepareStatement("select * from users where login = ?;");
        }
        catch (SQLException e){
            throw new SQLException("unable to connect");
        }
    }

    /**
     * Method that disconnects connection between our program and MySQL database
     */
    public void disconnect(){
        try {
            preparedStatementCheckUser.close();
            preparedStatementLogin.close();
            preparedStatementConfirm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
