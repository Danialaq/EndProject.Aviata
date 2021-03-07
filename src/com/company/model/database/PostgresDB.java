package com.company.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/EndProject"; // link to our data base
        try {
            Class.forName("org.postgresql.Driver"); // driver
            return DriverManager.getConnection(connectionURL, "postgres", "0000"); // connect to postgre database
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}