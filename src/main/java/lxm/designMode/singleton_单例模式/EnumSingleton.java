package lxm.designMode.singleton_单例模式;

/**
 * 枚举单例
 * Java创始人之一写的Effective Java 这本书里写了枚举单例
 */
public enum EnumSingleton {
    INSTANCE;

    public void m() {
        System.out.println("枚举单例");
    }
}

class Main {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.m();
    }
}