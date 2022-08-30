package yinhang;

public class textaccount {
    public static void main(String[] args) throws InterruptedException{
        bankaccount bankaccount=new bankaccount("2022-5-26",5000);
        operateaccount o1=new operateaccount(1,bankaccount,-2000);
        operateaccount o2=new operateaccount(2,bankaccount,2000);
        operateaccount o3=new operateaccount(3,bankaccount,-3000);
        operateaccount o4=new operateaccount(4,bankaccount,-1000);
        o1.start();
        o1.join();
        o2.start();
        o2.join();
        o3.start();
        o3.join();
        o4.start();
    }
}
