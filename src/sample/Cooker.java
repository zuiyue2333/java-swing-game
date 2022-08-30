package yinhang;

public class Cooker extends Thread{
    public Product product;
    public Cooker(Product product){
        this.product=product;
    }
    @Override
    public void run(){
        synchronized (this.product){
            for(int i=1;i<=15;i++){
                try{
                    this.product.putProduct ( i );
                    System.out.println ( "厨师往柜子里放汉堡"+i );
                    sleep ( 100 );
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }


            }
        }
    }
}