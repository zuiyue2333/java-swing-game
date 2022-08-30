package sample;

import java.sql.*;

/*public class demo_mysql {
            public static void main(String[] args) {
                Connection conn=null;
                Statement stem=null;
                ResultSet rest=null;
                try {
                    //1.注册驱动
                    //Class.forName("com.mysql.cj.jdbc.Driver");
                    Driver d=new com.mysql.jdbc.Driver();
                    DriverManager.registerDriver(d);
                    //2.通过drivermanager获取数据库连接
                    String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
                    String username="sa";
                    String password="";
                    conn=DriverManager.getConnection(url,username,password);
                    //3.用connection获取statement对象
                    stem=conn.createStatement();
                    //4.使用statement执行sql语句，获得resultset结果集
                    String sql="select * from userp";
                    rest=stem.executeQuery(mysql);
                    //5.操作resultset结果集
                    System.out.println ( "id | name | email | birthday" );
                    while (rs.next ()){
                        int id=rs.getInt ( "id" );
                        String name=rs.getString ( 2 );
                        String email=rs.getString ( "email" );
                        Date birthday=rs.getDate ( 4 );
                        System.out.println ( id+" |"+name+" |"+email+" |"+birthday );
                    }

                }catch (Exception e){
                    e.printStackTrace ();
                }
                //关闭连接，释放资源。先R,再S,后C
                finally {
                    if(rs!=null){
                        try {
                            rs.close ();
                        }catch (SQLException e){
                            e.printStackTrace ();
                        }
                        rs=null;
                    }
                    if(stmt!=null){
                        try {
                            stmt.close ();
                        }catch (SQLException e){
                            e.printStackTrace ();
                        }
                        stmt=null;
                    }
                    if(conn!=null){
                        try {
                            conn.close ();
                        }catch (SQLException e){
                            e.printStackTrace ();
                        }
                        conn=null;
                    }
                }
            }

}*/


