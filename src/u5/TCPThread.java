package u5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPThread extends Thread {
    Socket socket;
    InputStream is;
    OutputStream os;
    public TCPThread(Socket socket){
        this.socket=socket;
        start ();
    }

    @Override
    public void run(){
        try {
            System.out.println ( "读取客户端发送的请求信息：" );
            is=socket.getInputStream ();
            byte[] buf2=new byte[1024];
            int lenn=is.read ( buf2 );
            System.out.println (
                    new String (buf2,0,lenn  ) );

            System.out.println ( "向客户端发送响应信息：" );
            os=socket.getOutputStream ();
            os.write ( ("成都东软学院欢迎你！").getBytes () );
            System.out.println ( "结束与客户端交互数据！" );
        }catch (Exception e){
            e.printStackTrace ();
        }finally {
            try {
                os.close ();
                is.close ();
                socket.close ();
            }catch (Exception e2){
                e2.printStackTrace ();
            }
        }
    }
}