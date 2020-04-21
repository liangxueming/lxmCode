package lxm.designMode.singleton_单例模式;

/**
 * 饿汉式  - 简单实用，推荐
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 */
public class HungrySingleton {
   private static final HungrySingleton INSTANCE=new HungrySingleton();

   private HungrySingleton(){};

   public static HungrySingleton getInstance(){return  INSTANCE;}

   public void m(){  System.out.println("饿汉式单例。。。"); }

    public static void main(String[] args) {
        HungrySingleton.getInstance().m();
        HungrySingleton instance1= HungrySingleton.getInstance();
        HungrySingleton instance2= HungrySingleton.getInstance();
        System.out.println(instance1== instance2);
    }
}

/**
 * 第二种写法，跟上面是一样的
 */
class HungrySingleton02{
    private static final HungrySingleton02 INSTANCE ;
    static {
        INSTANCE=new HungrySingleton02();
    }
    private HungrySingleton02(){};

    public static HungrySingleton02 getInstance(){return INSTANCE;}

    public void m(){  System.out.println("饿汉式单例。。。"); }
}