package test;

import java.util.concurrent.atomic.AtomicInteger;
//用线程来验证原子性是什么
public class Atomic {
    public static void main(String[] args) {
        Aa a = new Aa();
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        Thread thread3 = new Thread(a);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Aa implements Runnable{
    AtomicInteger a = new AtomicInteger(0);
    public void add(){
        System.out.println(a.getAndAdd(1));
    }
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
