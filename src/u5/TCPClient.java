package u5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    private static final int PORT=7799;
    public void connect()throws Exception{
        Socket client=new Socket ( InetAddress.getLocalHost (),PORT );

        System.out.println ( "向服务器端发送请求信息：" );
        OutputStream os=client.getOutputStream ();
        os.write ( ("服务器，我要和你建立连接！").getBytes () );

        System.out.println ( "读取服务器端发送的响应信息：" );
        InputStream is=client.getInputStream ();
        byte[] buf1=new byte[1024];
        int len=is.read ( buf1 );
        System.out.println (
                new String ( buf1,0,len ) );

        is.close ();
        os.close ();
        client.close ();
    }
}