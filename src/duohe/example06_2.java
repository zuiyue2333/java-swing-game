package duohe;

class Task implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println ( Thread.currentThread ().getName ()+"正在输出："+i );
        }
    }
}
public class example06_2 {
    public static void main(String[] args) {
        Thread minPriority=new Thread ( new Task (),"优先级较低的线程" );
        Thread maxPriority=new Thread ( new Task (),"优先级较高的线程" );
        minPriority.setPriority ( Thread.MIN_PRIORITY );
        maxPriority.setPriority ( Thread.MAX_PRIORITY );
        minPriority.start ();
        maxPriority.start ();
        for(int j=9;j>=0;j--){
            System.out.println ( Thread.currentThread ().getName ()+":"+"j="+j );
        }
    }
}