package yinhang;

public class operateaccount extends Thread{
    private bankaccount account;
    private int index;
    private double money;
    public operateaccount(int index,bankaccount account,double money){
        this.account=account;
        this.index=index;
        this.money=money;
    }
    @Override
    public void run(){
        try {
        this.account.openaccount(index,money);}catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
