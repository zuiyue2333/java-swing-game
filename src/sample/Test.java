package yinhang;

public class Test {
    public static void main(String[] args) {
        Product product=new Product ();
        Cooker cooker=new Cooker ( product );
        Waiter waiter=new Waiter ( product );
        Dog dog=new Dog ( product );
        cooker.start ();
        waiter.start ();
        dog.start ();
    }
}
