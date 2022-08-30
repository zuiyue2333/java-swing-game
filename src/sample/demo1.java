package sample;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class demo1 {
    public static void main(String[] args) {
        Connection connectio=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
            String usename="root";
            String password="123456";
            connectio=DriverManager.getConnection(url,usename,password);
            String sql="insert into users(name,email,values(?,?,?))";
            preparedStatement=connectio.prepareStatement(sql);
            preparedStatement.setString(1,"zhangsan");
            preparedStatement.setString(2,"114514#@q.com");
            preparedStatement.setString(3,"1979-09-24");
            int result=preparedStatement.executeUpdate();
            System.out.println("插入"+result+"行");
        }
           catch (Exception e){
            e.printStackTrace();
           }
        finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (Exception e){
                    preparedStatement=null;
                }
            }
            if(connectio!=null){
                try {
                    connectio.close();
                }catch (Exception e){
                    connectio=null;                }
            }
        }
    }
}
