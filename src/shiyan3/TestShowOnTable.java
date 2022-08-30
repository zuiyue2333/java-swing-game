package shiyan3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class TestShowOnTable extends JFrame {
    // 定义表格
    JTable table;
    // 定义滚动条面板(用以使表格可以滚动)
    JScrollPane scrollPane;
    // 定义数据模型类的对象(用以保存数据)，
    DefaultTableModel tableModel;
    public TestShowOnTable() {
        super();
        setTitle("图书表");
        scrollPane = new JScrollPane();
// 定义表格列名数组
        final String[] columnNames = { "序号", "图书编号", "书名", "作者", "出版社", "单价",
                "出版日期", "ISBN", "库存数量" };
// 表格数据数组
        BookinfoDAO bdao = new BookinfoDAO();
        List<Bookinfo> books = bdao.getList();
        String tableValues[][] = new String[books.size()][9];
        for (int i = 0; i < books.size(); i++) {
            Bookinfo book = books.get(i);
            tableValues[i][0] = Integer.toString(book.getId());
            tableValues[i][1] = book.getBookNo();
            tableValues[i][2] = book.getBookname();
            tableValues[i][3] = book.getAuthor();
            tableValues[i][4] = book.getPublisher();
            tableValues[i][5] = Double.toString(book.getPrice());
            tableValues[i][6] = book.getPublishtime();
            tableValues[i][7] = book.getISBN();
            tableValues[i][8] = Integer.toString(book.getAmount());
        }
// 创建指定表格列名和表格数据的表格模型类的对象
        tableModel = new DefaultTableModel(tableValues, columnNames);
// 创建指定表格模型的表格
        table = new JTable(tableModel);
// 设置 RowSorter(RowSorter 用于提供对 JTable 的排序和过滤)。
        table.setRowSorter(new TableRowSorter<DefaultTableModel>(tableModel));
        scrollPane.setViewportView(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        table.setEnabled(false);// 禁止修改
        setBounds(700, 400, 1000, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]) {
        new TestShowOnTable();
    }
}
