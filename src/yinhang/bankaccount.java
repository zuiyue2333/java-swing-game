package yinhang;

public class bankaccount {
    private String number;//日期
    private double yu_e;
    public bankaccount(){}
    public bankaccount(String number, double yu_e){
        this.number=number;
        this.yu_e=yu_e;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public void setYu_e(double yu_e) {
        this.yu_e = yu_e;
    }
    public String getNumber() {
        return number;
    }
    public double getYu_e() {
        return yu_e;
    }
    public synchronized void openaccount(int index,double money)throws InterruptedException{
        double yu_e11=this.yu_e;
        if (money<0&&yu_e<-money){
            System.out.println(index+"对不起，余额不足");
        }else {
            yu_e11+=money;
            this.setYu_e(yu_e11);
            System.out.println("第"+index+"次操作,您当前的余额为:"+yu_e11);
        }
    }
}
