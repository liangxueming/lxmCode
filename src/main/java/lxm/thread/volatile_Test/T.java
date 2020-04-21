package lxm.thread.volatile_Test;

import java.util.ArrayList;

/**
 * volatile
 *  保证线程可见性
 *      MESI
 *      缓存一致性协议
 *  禁止指令重排序(CPU)
 *      DCL单例
 *      Double Check Lock
 *      loadfence原语指令
 *      storefence原语指令
 *
 *  并不能保证多个线程共同修改running变量时所带来的不一致的问题，也就是说volatile不能替代synchronzied
 */
public class T {
    volatile int  count = 0;

   /* synchronized */  public void m() {
       for (int i = 0; i < 10000; i++){
           count++;
       }
    }

    public static void main(String[] args) throws InterruptedException {
        while(true){
            T t = new T();
            t.test();
            Thread.sleep(200);
        }
    }

    /**
     * 测试代码
     */
    public  void test(){
        T t = new T();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int j=0;j<10;j++){
            threads.add(new Thread(t::m,"thread-"+j));
        }
        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("count="+t.count);
    }
}
