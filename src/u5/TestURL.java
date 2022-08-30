package u5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestURL {
    public static void main(String[] args) {
        try {
            String s_url="https://www.baidu.com/";
            URL url=new URL ( s_url );
            System.out.println ( url.getAuthority () );
            System.out.println ( url.getContent () );
            System.out.println ( url.getDefaultPort () );
            System.out.println ( url.getFile () );
            System.out.println ( url.getHost () );
            System.out.println ( url.getPort () );
            System.out.println ( url.getPath () );
            System.out.println ( url.getProtocol () );
            //返回指定资源的字节输入流
            URLConnection conn=url.openConnection ();
            InputStream in=conn.getInputStream ();
            //InputStream in=url.openStream ();
            BufferedReader Bread=new BufferedReader (
                    new InputStreamReader ( in ) );

            String msg=null;
            while ((msg=Bread.readLine ())!=null){
                System.out.println ( msg );
            }
            Bread.close ();
            in.close ();
        }catch (MalformedURLException e){
            e.printStackTrace ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
