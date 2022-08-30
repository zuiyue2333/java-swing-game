package duohe;

class Task01 implements Runnable{
    @Override
    public void run(){
        for(int i=1;i<=10;i++){
            try {
                if(i==3){
                    Thread.sleep ( 10000 );
                }
                System.out.println ( "子线程正在输出："+i );
            }catch (Exception e){
                e.printStackTrace ();
            }
        }
    }
}

public class example07 {
    public static void main(String[] args)throws Exception {
        new Thread ( new Task01 () ).start ();
        for(int j=1;j<=10;j++){
            if(j==5){
                Thread.sleep ( 10000 );
            }
            System.out.println ( "main主线程正在输出："+j );
        }
    }
}