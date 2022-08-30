import java.sql.*;

/*public class demo {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stem=null;
        ResultSet rest=null;
        try {
            //1.注册驱动
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Driver d=new com.microsoft.sqlserver.jdbc.SQLServerDriver();
            DriverManager.registerDriver(d);
            //2.通过drivermanager获取数据库连接
            String url="jdbc:sqlserver://localhost:1433/jdbc?serverTimezone=UTC";
            String username="sa";
            String password="";
            conn=DriverManager.getConnection(url,username,password);
            //3.用connection获取statement对象
            stem=conn.createStatement();
            //4.使用statement执行sql语句，获得resultset结果集
            String sql="select * from userp";
            rest=stem.executeQuery(sql);
            //5.操作resultset结果集
            //关闭连接，释放资源。先R,再S,后C
        }
    }
}*/
