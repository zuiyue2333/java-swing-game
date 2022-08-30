package duohe;

import java.lang.Thread;
class TicketWindow04 implements Runnable{
    private int tickets=10;
    Object lock=new Object ();
    @Override
    public void run (){
        while (true){
            try {
                Thread.sleep ( 10 );
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
            synchronized (lock){
                if(tickets>0){
                    System.out.println (
                            Thread.currentThread ().getName ()+
                                    ":卖出第"+tickets--+"张票" );
                }else {
                    break;
                }
            }
        }
    }
}
public class tongbu_1 {
    public static void main(String[] args) {
        TicketWindow04 task=new TicketWindow04 ();
        new Thread ( task, "窗口1" ).start ( );
        new Thread (task, "窗口2" ).start ( );
        new Thread ( task, "窗口3" ).start ( );
        new Thread ( task, "窗口4" ).start ( );
    }
}