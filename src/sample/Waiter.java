package yinhang;
public class Waiter extends Thread{
    public Product product;
    public Waiter(Product product){
        this.product=product;
    }
    @Override
    public void run(){
        synchronized (this.product){
            for(int i=1;i<=15;i++){
                try{
                    int result=this.product.getProduct ();
                    System.out.println ( "服务员取走了"+result );
                    sleep ( 100 );
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }

            }
        }
    }
}
