package lxm.designMode.singleton_单例模式;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class StaticSingleton {
    private static class StaticSingletonHolder{
        private final static StaticSingleton INSTANCE =new StaticSingleton();
    }

    private StaticSingleton(){};

    public static StaticSingleton getInstance(){
        return StaticSingletonHolder.INSTANCE;
    }

    public void m(){
        System.out.println("静态内部类实现单例。。。");
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(StaticSingleton.getInstance().hashCode());
            }).start();
        }
    }

}
