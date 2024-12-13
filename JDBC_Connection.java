import java.sql.*;
public class JDBC_Connection {
    public Connection conn;
    public Statement s;
    PreparedStatement p;
     public JDBC_Connection(){
         try {
           /* String url1="jdbc:mysql://localhost:3306/Hostel_Project";
            String userName="root";
            String passWord="pr@G@ti2005";*/
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_project", "root", "Pr@g@ti2005");


             s=conn.createStatement();
         }
         catch (Exception e){
             System.out.println(e);
         }
     }
}
/*
import java.sql.*;
public class JDBCdemo {
    public static void main(String []args) {
        try {
            String url1="jdbc:mysql://localhost:3306/";
            String userName="root";
            String passWord="pr@G@ti2005";

            Connection conn=DriverManager.getConnection(url1,userName,passWord);
            System.out.println("Connected Successfully !");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
 */