package lxm.thread.CAS_无锁优化.AtomicXXX;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 与lxm.thread.volatile_Test.T 对比
 */
public class T01_AtomicInteger {
    //    volatile int  count = 0;
    AtomicInteger count = new AtomicInteger(0);

    void m()  {
        for (int i = 0; i < 10000; i++) {
//            count++;
            int i1 = count.incrementAndGet();
//            System.out.println(i1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            T01_AtomicInteger t = new T01_AtomicInteger();
            t.test();
            Thread.sleep(200);
        }
    }

    /**
     * 测试代码
     */
    public void test() {
        T01_AtomicInteger ta = new T01_AtomicInteger();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            threads.add(new Thread(ta::m, "thread-" + j));
        }
        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("count=" + ta.count);
    }

}
