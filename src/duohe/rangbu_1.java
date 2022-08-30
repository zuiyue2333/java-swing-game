package duohe;
class yield extends Thread{
    public yield(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i=0;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"i="+i);
            if (i==3){
                System.out.println(Thread.currentThread().getName()+"做出让步......");
                Thread.yield();
            }
        }
    }
}
public class rangbu_1 {
    public static void main(String[] args) {
        Thread t1=new yield("线程1");
        Thread t2=new yield("线程2");
        t1.start();
        t2.start();
    }
}
