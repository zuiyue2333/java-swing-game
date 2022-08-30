package duohe;

import java.text.SimpleDateFormat;
import java.util.Date;
class ShowDate implements Runnable{
    int count=0;
    @Override
    public void run(){
        while (true){
            Date now=new Date ( ) ;
            SimpleDateFormat sdf=new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            String time=sdf.format ( now );
            System.out.println ( time );
            count++;
            if(count>10){
                break;
            }
            try{
                Thread.sleep ( 1000 );
            }catch (InterruptedException e){
                e.printStackTrace ();
            }

        }
    }
}

public class datedemo {
    public static void main(String[] args) {
        ShowDate showDate=new ShowDate ();
        Thread thread=new Thread ( showDate );
        thread.start ( );
        //new Thread ( new ShowDate () ).start ();
    }
}
