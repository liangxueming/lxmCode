package lxm.designMode.factory_工厂模式.简单工厂;

public class Car implements  Moveable{

    @Override
    public void go() {
        System.out.println("汽车冲到一百二十迈。。。。");
    }
}
