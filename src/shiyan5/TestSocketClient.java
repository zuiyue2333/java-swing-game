package shiyan5;

/*客户端*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class TestSocketClient extends JFrame{
        private PrintWriter writer;
        private BufferedReader reader;
        private Socket socket;
        private JTextArea ta_info;
        private JTextField tf_send;
        private void connect(){//连接套接字方法
        ta_info.append("尝试连接......\n");//文本域中提示信息
        try{//捕捉异常
        socket=new Socket("127.0.0.1",1978);//实例化Socket对象
        while(true){
        writer=new
        PrintWriter(socket.getOutputStream(),true);
        reader=new BufferedReader(new
        InputStreamReader(
        socket.getInputStream()));
        ta_info.append("完成连接。\n");//文本域中提示信息
        getServerInfo();
        }
        }catch(Exception e){
        e.printStackTrace();//输出异常信息
        }
        }
        public static void main(String[]args){
        TestSocketClient clien=new TestSocketClient();
        clien.setVisible(true);
        clien.connect();//调用连接方法
        }
        private void getServerInfo(){
        try{
        while(true){
        if(reader!=null){
        String line=reader.readLine();//读取服务器发送的信息
        if(line!=null)
        ta_info.append("接收到服务器发送的信息："
        +line+"\n");//显示服务器端发送的信息
        }
        }
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        try{
        if(reader!=null){
        reader.close();
        }
        if(socket!=null){
        socket.close();
        }
        }catch(IOException e){
        e.printStackTrace();
        }
        }
        }
/**
 *Createtheframe
 */
        public TestSocketClient(){
        super();
        setTitle("客户端程序");
        setBounds(100,100,361,257);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel=new JPanel();
        getContentPane().add(panel,BorderLayout.NORTH);
        final JLabel label=new JLabel();
        label.setForeground(new Color(0,0,255));
        label.setFont(new Font("",Font.BOLD,22));
        label.setText("一对一通信――客户端程序");
        panel.add(label);
        final JPanel panel_1=new JPanel();
        getContentPane().add(panel_1,BorderLayout.SOUTH);
        final JLabel label_1=new JLabel();
        label_1.setText("客户端发送的信息：");
        panel_1.add(label_1);
        tf_send=new JTextField();
        tf_send.setPreferredSize(new Dimension(140,25));
        panel_1.add(tf_send);
        final JButton button=new JButton();
        button.addActionListener(new ActionListener(){
        public void actionPerformed(final ActionEvent e){
        writer.println(tf_send.getText());//将文本框中信息写入流
        ta_info.append("客户端发送的信息是："+
        tf_send.getText()
        +"\n");//将文本框中信息显示在文本域中
        tf_send.setText("");//将文本框清空
        }
        });
        button.setText("发送");
        panel_1.add(button);
        final JScrollPane scrollPane=new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        ta_info=new JTextArea();
        scrollPane.setViewportView(ta_info);
        }
        }