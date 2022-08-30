package shiyan3;

import java.util.List;

public class TestUpdateBook {
    public static void main(String[] args) {
        BookinfoDAO bdao = new BookinfoDAO();
        Bookinfo book = new Bookinfo("0233", "操作系统", "戴远泉");
        List<Bookinfo> books ;
        books = bdao.gueryByBookName(book.getBookname());
        for (Bookinfo bookInfo : books) {
            System.out.println(bookInfo.getId() + "\t" + bookInfo.getBookNo()
                    + "\t" + bookInfo.getBookname() + "\t"
                    + bookInfo.getAuthor());
        }
        book.setId(books.get(0).getId());
        book.setBookname("操作系统原理");
        book.setAuthor("王军");
        book.setPublisher("机械工业出版社");
        book.setPublishtime("20180802");
        book.setPrice(56);
        book.setISBN("98722011018");
        book.setAmount(40);
        if (bdao.update(book)) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }
}
