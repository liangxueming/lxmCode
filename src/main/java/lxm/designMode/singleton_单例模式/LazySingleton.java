package lxm.designMode.singleton_单例模式;

/**
 * 懒汉式
 * 定义INSTANCE 时需要加volatile ，防止指令重排序
 * 不加锁线程不安全
 */
public class LazySingleton {
    private static volatile LazySingleton INSTANCE;

    private LazySingleton(){};

    /**
     * 线程安全
     * @return
     */
    synchronized public static LazySingleton getInstance(){
        if(INSTANCE==null){
            return new LazySingleton();
        }
        return INSTANCE;
    }

    /**
     * 线程安全
     * @return
     */
    public static LazySingleton getInstance04(){
        if(INSTANCE==null){
            synchronized (LazySingleton.class){
                //双重检查
                if(INSTANCE==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE=new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 线程不安全
     * @return
     */
     public static LazySingleton getInstance02(){
        if(INSTANCE==null){
            INSTANCE= new LazySingleton();
        }
        return INSTANCE;
    }

    /**
     * 线程不安全
     * @return
     */
    public static LazySingleton getInstance03(){
        if(INSTANCE==null){
            //企图通过减少同步代码块的方式提高效率，然后不可行
            synchronized (LazySingleton.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE= new LazySingleton();
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("懒汉。。。");
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(() -> {
                System.out.println(LazySingleton.getInstance04().hashCode());
            }).start();
        }
    }
}
