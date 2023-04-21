package com.example.connectdb.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class postgresDB {
    private Connection c = null;
    public Connection connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void closeBD() throws SQLException {
        c.close();
    }
}
