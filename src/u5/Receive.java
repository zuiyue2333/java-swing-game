package u5;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
public class Receive {
    public static void main(String[] args) {
        //..
        DatagramSocket ds=null;
        try {
            ds=new DatagramSocket ( 8956 );
        }catch (SocketException e){
            e.printStackTrace ();
        }
        //..
        byte[] data=new byte[1024];
        DatagramPacket dp=new DatagramPacket ( data,data.length );
        //...
        System.out.println ( "等待接收数据！" );
        try {
            ds.receive ( dp );
        }catch (IOException e){
            e.printStackTrace ();
        }
        //..
        String str=new String (
                dp.getData (),0,dp.getLength ())+
                "from"+dp.getAddress ().getHostAddress ()+
                ":"+dp.getPort ();
        System.out.println ( str );
        //..
        ds.close ();

    }
}