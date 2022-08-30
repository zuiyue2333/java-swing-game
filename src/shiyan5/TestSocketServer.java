package shiyan5;

/*服务器端*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class TestSocketServer extends JFrame{
        private JTextField tf_send;
        private JTextArea ta_info;
        private PrintWriter writer;
        private BufferedReader reader;
        private ServerSocket server;
        private Socket socket;
        public void getServer(){
        try{
        server =new ServerSocket(1978);//实例化Socket对象
        ta_info.append("服务器套接字已经创建成功\n");
        while(true){//如果套接字是连接状态
        ta_info.append("等待客户机的连接......\n");
        socket=server.accept();//返回Socket类型的对象
        reader=new BufferedReader(new
        InputStreamReader(socket.getInputStream()));
        writer=new PrintWriter(socket.getOutputStream(),true);
        getClientInfo();//调用getClientInfo()方法
        }
        }catch(Exception e){
        e.printStackTrace();
        }
        }
        private void getClientInfo(){
        try{
        while(true){
        String line=reader.readLine();//读取客户端发送的信息
        if(line!=null)
        ta_info.append("接收到客户机发送的信息："+
        line+"\n");//显示客户端发送的信息
        }
        }catch(Exception e){
        ta_info.append("客户端已退出。\n");//输出异常信息
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
        public static void main(String[]args){
        TestSocketServer frame=new TestSocketServer();
        frame.setVisible(true);
        frame.getServer();//调用方法
        }
        public TestSocketServer(){
        super();
        setTitle("服务器端程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,379,260);
        final JScrollPane scrollPane=new JScrollPane();
        getContentPane().add(scrollPane,
        BorderLayout.CENTER);
        ta_info=new JTextArea();
        scrollPane.setViewportView(ta_info);
        final JPanel panel=new JPanel();
        getContentPane().add(panel,BorderLayout.SOUTH);
        final JLabel label=new JLabel();
        label.setText("服务器发送的信息：");
        panel.add(label);
        tf_send=new JTextField();
        tf_send.setPreferredSize(new Dimension(150,25));
        panel.add(tf_send);
        final JButton button=new JButton();
        button.addActionListener(new ActionListener(){
        public void actionPerformed(final ActionEvent e){
        writer.println(tf_send.getText());//将文本框中信息写入流
        //将文本框中信息显示在文本域中
        ta_info.append("服务器发送的信息是："+
        tf_send.getText()+"\n");
        tf_send.setText("");//将文本框清空
        }
        });
        button.setText("发送");
        panel.add(button);
        final JPanel panel_1=new JPanel();
        getContentPane().add(panel_1,BorderLayout.NORTH);
        final JLabel label_1=new JLabel();
        label_1.setForeground(new Color(0,0,255));
        label_1.setFont(new Font("",Font.BOLD,22));
        label_1.setText("一对一通信——服务器端程序");
        panel_1.add(label_1);
        }
        }
