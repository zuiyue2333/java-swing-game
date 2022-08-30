package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo_2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try{
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
            String username="root";
            String password="123456";
            conn= DriverManager.getConnection ( url,username,password );
            stmt=conn.createStatement ();
            String sql="INSERT INTO users(name,email,birthday)" +
                    "VALUES('zhangli','111@qq.com','1978-05-24')";
            int result=stmt.executeUpdate ( sql );
            System.out.println ( "插入"+result+"行！" );
        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close ();
                }catch (SQLException e){
                    e.printStackTrace ();
                }
                stmt=null;
            }
            if(conn!=null){
                try{
                    conn.close ();
                }catch (SQLException e){
                    e.printStackTrace ();
                }
                conn=null;
            }

        }


    }
}
