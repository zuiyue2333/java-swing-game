package duohe;

class YYThread implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<6;i++){
            System.out.println ( Thread.currentThread ().getName ()+"输出："+i );
            try{
                Thread.sleep ( 2000 );
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
    }
}
public class xiumian {
    public static void main(String[] args) throws Exception {
        Thread t=new Thread ( new YYThread (),"线程1" );
        t.start ();
        for(int i=0;i<6;i++){
            System.out.println ( Thread.currentThread ().getName ()+"输出："+i );
            if(i==2){
                t.join ();
            }
            Thread.sleep ( 5000 );
        }
    }
}