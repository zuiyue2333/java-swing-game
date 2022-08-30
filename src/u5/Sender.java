package u5;

import java.io.IOException;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        InetAddress address=null;
        try {
            address=InetAddress.getByName ( "localhost" );
        }catch (UnknownHostException e){
            e.printStackTrace ();
        }
        int port=8956;
        String str="Hello word!";
        byte[] arr=str.getBytes ();
        //创建数据报
        DatagramPacket dp=new DatagramPacket ( arr,arr.length,address,port );
        //..
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket (  );
        }catch (SocketException e){
            e.printStackTrace ();
        }
        //...
        System.out.println ( "发送信息！" );
        try {
            socket.send ( dp );
        }catch (IOException e){
            e.printStackTrace ();
        }
        //...
        socket.close ();
    }
}