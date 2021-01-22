package tools;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;


public class MysqlTool {
    private static Properties sqlConf = new Properties();

    // use Properties to reset the configuration without stopping the program
    static{
        InputStream configuration = MysqlTool.class.getResourceAsStream("datasource.properties");

        try{
            sqlConf.load(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection connectToDB(){
        Connection conn = null;

        try{
            // register for driver
            Class.forName(sqlConf.getProperty("JDBC_DRIVER"));
            System.out.println("Connecting MySQL");
            conn = DriverManager.getConnection(sqlConf.getProperty("DB_URL"),
                    sqlConf.getProperty("USER"), sqlConf.getProperty("PASSWORD"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn){
        try{
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt){
        try{
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        try{
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
