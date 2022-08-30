package duohe;

import java.lang.Thread;
public class example06_1 {
    public static void main(String[] args) {
        System.out.println(
                Thread.currentThread().getName()+
                        "的优先级是："+
                        Thread.currentThread().getPriority());

        TestPriority tp1=new TestPriority();
        System.out.println(tp1.getName()+
                "的优先级是："+
                tp1.getPriority());

        //改变main线程的优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println(Thread.currentThread().getName()+
                "的优先级是："+
                Thread.currentThread().getPriority());
        System.out.println(tp1.getName()+
                "的优先级是："+
                tp1.getPriority());

        TestPriority tp2=new TestPriority();
        System.out.println(tp2.getName()+"的优先级是："+tp2.getPriority());
        System.out.println();

        tp1.start();
        tp2.start();
    }
}
class TestPriority extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +
                    "正在输出" + i);
        }
    }
}