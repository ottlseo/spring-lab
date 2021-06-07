package like;

import java.sql.*;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://database-master.cjg477cwca9i.ap-northeast-2.rds.amazonaws.com";

    static final String USER = "DB2021Team04";
    static final String PASS = "DB2021Team04";


    public void insert(String value, String movie_name) {
        String query = "INSERT INTO db2021_like(user_nickname, movie_id) value (?,(select id from db2021_movie where title=?))";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                PreparedStatement pStmt = conn.prepareStatement(query);

        ) {
            System.out.println(value);
/*
            stmt.executeQuery("use DB2021Team04");
            pStmt.setString(1, value);
            pStmt.setString(2, movie_name);
            pStmt.executeUpdate();


 */
        } catch (SQLException se) {
            System.out.println("error");
            se.printStackTrace();
        }
    }

    public void delete(String value, String movie_id) {
        String query = "DELETE FROM DB2021_like where user_nickname=? and movie_id=(select id from db2021_movie where title=?)";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                PreparedStatement pStmt = conn.prepareStatement(query);

        ) {
            stmt.executeQuery("use DB2021Team04");
            pStmt.setString(1, value);
            pStmt.setString(2, movie_id);
            pStmt.executeUpdate();

        } catch (SQLException se) {
            System.out.println("error");
            se.printStackTrace();
        }
    }
}