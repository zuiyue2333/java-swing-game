package yinhang;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public List<Integer> list=new ArrayList( );
    public final int MAX_count=10;
    public final int MIN_count=0;

    public synchronized void putProduct(int value)throws InterruptedException{
        while (list.size ()>=MAX_count){
            System.out.println ( "柜子已经满了，不能再装了！" );
            wait ();
        }
        list.add ( value );
        notify ();
    }

    public synchronized int getProduct()throws InterruptedException{
        while (list.size ()==MIN_count){
            System.out.println ( "柜子已经空，不能再取了！" );
            wait ();
        }
        int result=list.remove ( 0 );
        notify ();
        return result;
    }
}