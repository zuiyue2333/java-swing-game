package shiyan3;

import java.util.List;

public class TestQueryBybookname {
    public static void main(String[] args) {
        BookinfoDAO bookInfoDAO = new BookinfoDAO();
        List<Bookinfo> books = bookInfoDAO.gueryByBookName("Java 程序设计");
        for (Bookinfo bookInfo :books) {
            System.out.println(bookInfo.getId() + "\t" + bookInfo.getBookNo()
                    + "\t" + bookInfo.getBookname() + "\t"
                    + bookInfo.getAuthor());
        }
    }
}
