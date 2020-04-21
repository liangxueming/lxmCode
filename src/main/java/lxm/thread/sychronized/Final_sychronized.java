package lxm.thread.sychronized;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o,如果o的属性发生改变，不影响锁的使用
 * 但是如果o变成另一个对象，则锁的对象发生改变，
 * 应该避免将锁定对用的引用变成另外的对象
 *
 * 注意 ！！！ 要上锁的对象加 final
 */
public class Final_sychronized {
   /* final */ Object o= new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Final_sychronized demo1 = new Final_sychronized();
        new Thread(demo1::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 以下是错误代码
         */
        Final_sychronized demo2 = new Final_sychronized();
        Thread t2 = new Thread(demo2::m, "t2");

        demo2.o = new Object();
        t2.start();
    }
}
