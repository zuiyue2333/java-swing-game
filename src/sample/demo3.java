package sample;
import java.sql.*;

public class demo3 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try{
            Class.forName ( "com.mysql.cj.jdbc.Driver" );

            String url="jdbc:mysql://localhost:3306/xkgl?serverTimezone=UTC";
            String username="root";
            String password="123456";

            conn= DriverManager.getConnection ( url,username,password );

            stmt=conn.createStatement (
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            String sql="select * from users";
            rs=stmt.executeQuery ( sql );

            System.out.println ( "第2条数据的name值：" );
            rs.absolute ( 2 );
            System.out.println ( rs.getString ( "name" ) );

            System.out.println ( "第1条数据的name值：" );
            rs.beforeFirst ();
            rs.next ();
            System.out.println ( rs.getString ( "name" ) );

            System.out.println ( "最后一条数据的name值：" );
            rs.afterLast ();
            rs.previous ();
            System.out.println ( rs.getString ( "name" ) );

        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            if(rs!=null){
                try{
                    rs.close ();
                }catch (SQLException e){
                    e.printStackTrace ();
                }
                rs=null;
            }
            if(stmt!=null){
                try{
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