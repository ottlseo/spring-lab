package search;

import java.sql.*;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://database-master.cjg477cwca9i.ap-northeast-2.rds.amazonaws.com";

    static final String USER = "DB2021Team04";
    static final String PASS = "DB2021Team04";

    public void searchDirector(String value) {
        String query = "SELECT * FROM db2021_movie WHERE director = ?";

        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            PreparedStatement pStmt = conn.prepareStatement(query);

        ) {
            stmt.executeQuery("use DB2021Team04");
            pStmt.setString(1, value);
            ResultSet rs = pStmt.executeQuery();

            if(!rs.next()){
                System.out.print("\""+value+"\"");
                System.out.println("로 검색한 결과가 없습니다.\n");
            }
            else{
                do {
                    System.out.print("\""+value+"\"");
                    System.out.println("로 검색한 결과입니다.");
                    String title = rs.getString(2);
                    String eng_title = rs.getString(3);
                    String director = rs.getString(4);
                    System.out.print(title);
                    System.out.print("\t\t\t" + eng_title);
                    System.out.println("\t\t\t" + director);
                    System.out.println();
                } while (rs.next());

            }

        } catch (SQLException se) {
            System.out.println("error");
            se.printStackTrace();
        }
    }

    public void searchTitle(String value) {
        String query = "SELECT * FROM db2021_movie WHERE title = ?";

        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            PreparedStatement pStmt = conn.prepareStatement(query);

        ) {
            stmt.executeQuery("use DB2021Team04");
            pStmt.setString(1, value);
            ResultSet rs = pStmt.executeQuery();

            if(!rs.next()){
                System.out.print("\""+value+"\"");
                System.out.println("로 검색한 결과가 없습니다.\n");
            }
            else{
                do {
                    System.out.print("\""+value+"\"");
                    System.out.println("로 검색한 결과입니다.");
                    String title = rs.getString(2);
                    String eng_title = rs.getString(3);
                    String director = rs.getString(4);
                    System.out.print(title);
                    System.out.print("\t\t\t" + eng_title);
                    System.out.println("\t\t\t" + director);
                    System.out.println();
                } while (rs.next());
            }

        } catch (SQLException se) {
            System.out.println("error");
            se.printStackTrace();
        }
    }
}
