package shiyan3;


public class TestAddBook {
    public static void main(String[] args) {
        BookinfoDAO bookInfoDAO = new BookinfoDAO();
        Bookinfo book = new Bookinfo(null, null, null);
        book.setBookNo("08813");
        book.setBookname("面向对象高级编程");
        book.setAuthor("周伟");
        book.setPublisher("高等教育出版社");
        book.setPublishtime("20180609");
        book.setAmount(4);
        book.setPrice(48.0);
        book.setISBN("98785382321");
        if(bookInfoDAO.addBook(book))
            System.out.println("添加成功！");
        else {
            System.out.println("添加失败！");
        }
    }
}