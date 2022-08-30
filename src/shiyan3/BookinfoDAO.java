package shiyan3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookinfoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    public boolean addBook(Bookinfo book){
        boolean flag=false;
        conn =DBManager.getConn();
        String sqlString="insert into bookinfo(bookNo,bookname,author,publisher,publishtime,price,ISBN,amount) values(?,?,?,?,?,?,?,?)";
                try{
                    ps=conn.prepareStatement(sqlString);
                    ps.setString(1,book.getBookNo());
                    ps.setString(2,book.getBookname());
                    ps.setString(3,book.getAuthor());
                    ps.setString(4,book.getPublisher());
                    ps.setString(5,book.getPublishtime());
                    ps.setDouble(6,book.getPrice());
                    ps.setString(7,book.getISBN());
                    ps.setInt(8,book.getAmount());
                    flag= ps.executeUpdate()!=0?true:false;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return flag;
    }
    public List<Bookinfo>gueryByBookName(String bname){
        List<Bookinfo>books=new ArrayList<Bookinfo>();
        conn=DBManager.getConn();
        String sqlString="select * from booinfo where bookname like ?";
        try {
            ps=conn.prepareStatement(sqlString);
            ps.setString(1,bname);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int bookId=rs.getInt("ID");
                String bookNo=rs.getString("bookNo");
                String bookname=rs.getString("bookname");
                String author=rs.getString("author");
                String publisher=rs.getString("publisher");
                String pubishtime=rs.getString("publishtime");
                String ISBN=rs.getString("ISBN");
                double price=rs.getDouble("price");
                int amount=rs.getInt("amount");
                Bookinfo book=new Bookinfo(bookNo,bookname,author);
                book.setId(bookId);
                book.setPublisher(publisher);
                book.setPublishtime(pubishtime);
                book.setISBN(ISBN);
                book.setPrice(price);
                book.setAmount(amount);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return books;
    }
    public List<Bookinfo> getList(){
        List<Bookinfo> books =new ArrayList<Bookinfo>();
        conn=DBManager.getConn();
        String sql="select * from bookinfo";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Bookinfo book=new Bookinfo();
                book.setId(rs.getInt(1));
                book.setBookNo(rs.getString(2));
                book.setBookname(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setPrice(rs.getDouble(6));
                book.setPublishtime(rs.getString(7));
                book.setISBN(rs.getString(8));
                book.setAmount(rs.getInt(9));
                books.add(book);
            }
            }catch(SQLException e){
            e.printStackTrace();
        }return books;
    }
    public boolean delBookById(int id){
        boolean flag =false;
        conn=DBManager.getConn();
        String sql ="delete from bookinfo where ID=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            if (ps.execute()){
                flag=true;
            }else {
                flag=false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean update(Bookinfo book){
        boolean flag=false;
        conn=DBManager.getConn();
        String sql="update bookinfo set bookNo=?,bookname=?,author=?,publisher=?,price=?,pulishtime=?,ISBN=?,amount=? where ID=? ";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,book.getBookNo());
            ps.setString(2,book.getBookname());
            ps.setString(3,book.getAuthor());
            ps.setString(4,book.getPublisher());
            ps.setString(5,book.getPublishtime());
            ps.setString(6,book.getISBN());
            ps.setDouble(7,book.getPrice());
            ps.setInt(8,book.getAmount());
            ps.setInt(9,book.getId());
            flag=ps.executeUpdate()>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }return flag;
    }
}
