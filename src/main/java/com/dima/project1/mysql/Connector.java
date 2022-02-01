package com.dima.project1.mysql;

import lombok.Getter;

import java.sql.*;

public class Connector {

    private Connection connection;
    private Statement statement;

    @Getter
    private PreparedStatement preparedStatementLogin;
    @Getter
    private PreparedStatement preparedStatementConfirm;
    @Getter
    private PreparedStatement preparedStatementCheckUser;

    public void connect() throws SQLException{
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", "root", "root12345");
            statement = connection.createStatement();
            preparedStatementLogin = connection.prepareStatement("select * from users where login = ? and pass = ?;");
            preparedStatementConfirm = connection.prepareStatement("insert into users(login, pass, visits) values(?, ?, 0);");
            preparedStatementCheckUser = connection.prepareStatement("select * from users where login = ?;");
        }
        catch (SQLException e){
            throw new SQLException("unable to connect");
        }
    }
    public void disconnect(){
        try {
            statement.close();
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
