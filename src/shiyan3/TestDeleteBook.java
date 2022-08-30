package shiyan3;

import java.util.List;

public class TestDeleteBook {
    public static void main(String[] args) {
        Bookinfo book = new Bookinfo();
        book.setBookname("面向对象高级编程");
        System.out.println("________________________");
        BookinfoDAO bookInfoDAO = new BookinfoDAO();
        List<Bookinfo> books = bookInfoDAO.gueryByBookName(book.getBookname());
        if (books.size() >= 1) {
            int bookid = books.get(0).getId();
            if (!bookInfoDAO.delBookById(bookid)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        }
    }
}