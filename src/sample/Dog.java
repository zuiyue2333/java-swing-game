package yinhang;

public class Dog extends Thread {
    public Product product;
    public Dog(Product product){
        this.product=product;
    }

    @Override
    public void run(){
        for(int i=1;i<=15;i++){
            try{
                int result=this.product.getProduct ();
                System.out.println ( "ηε·εδΊ"+result );
                sleep ( 100 );
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
    }
}
