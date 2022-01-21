package com.flintcore.datos;

import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_cliente?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String JDBC_USER = "root";

    private static final String JDBC_PASS = "Mosquea42510";

    // Variables
    private static DataSource dbs;

    public static DataSource getDataSource() {

        if (dbs == null) {
            BasicDataSource db = new BasicDataSource();
            db.setUrl(JDBC_URL);
            db.setUsername(JDBC_USER);
            db.setPassword(JDBC_PASS);
            db.setInitialSize(50);
            dbs = db;
        }

        return dbs;
    }

    public static Connection getConnection() throws SQLException {
                return getDataSource().getConnection();
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement stm){
        try {
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection cn){
        try {
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
