import java.sql.*;
import java.io.*;
/**
 * MySql 에 이미지 저장하는 루틴
 * CREATE TABLE tbl_test (
 * ID INTEGER PRIMARY KEY,
 * FILENAME VARCHAR(50) NOT NULL,
 * FILE MEDIUMBLOB NOT NULL
 * );
 * */


public class img_test {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static void main(String[] args)
    {

        System.out.println("Insert Image Example!");
        //String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/efub_ebs";
        //String dbName = "efub_ebs";
        String userName = "root";
        String password = "";
        Connection con = null;

        try{
            //Class.forName(driverName);
            con = DriverManager.getConnection(url,userName,password);

            File imgfile = new File("./ebs_image/1.png");
            FileInputStream fin = new FileInputStream(imgfile);
            PreparedStatement pre = con.prepareStatement(
                    "insert into img_test (ID, FILENAME, FILE) VALUES (?, ?, ?)");
            pre.setInt(1,1);
            pre.setString(2,"오디오 어학당");
            pre.setBinaryStream(3,fin,(int)imgfile.length());//Stream형의 파일 업로드
            pre.executeUpdate();

            System.out.println("Inserting Successfully!");
            pre.close();
            con.close();

        } catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }

}
