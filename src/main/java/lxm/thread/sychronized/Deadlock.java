package lxm.thread.sychronized;

/**
 * 死锁
 */
public class Deadlock {
    public static void main(String[] args) {
        DeadLockThread lockThread1 = new DeadLockThread(true);
        DeadLockThread lockThread2 = new DeadLockThread(false);
        new Thread(lockThread1).start();
        new Thread(lockThread2).start();
    }
}

class DeadLockThread implements  Runnable{
    boolean  flag=true;
    static Object o1 = new Object();//这里必须是静态变量，否则加锁就不是在同一个对象上加锁了
    static Object o2 = new Object();

    public  DeadLockThread(boolean flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        if(flag){
            synchronized (o1){
                try {
                    System.out.println(Thread.currentThread().getName()+" o1已上锁，开始睡眠");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" o1开始准备拿o2的锁");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+ " o1拿到o2的锁");
                }
                System.out.println(Thread.currentThread().getName()+"== end");
            }
        }else{
            synchronized(o2){
                 System.out.println(Thread.currentThread().getName()+" o2已上锁，开始睡眠");

                System.out.println(Thread.currentThread().getName()+" o2开始准备拿o1的锁");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+ " o2拿到o1的锁");
                }
                System.out.println(Thread.currentThread().getName()+"=== end ");
            }
        }
    }
}