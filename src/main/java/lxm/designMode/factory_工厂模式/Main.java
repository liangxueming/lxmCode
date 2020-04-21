package lxm.designMode.factory_工厂模式;

import lxm.designMode.factory_工厂模式.工厂方法.CarFactory;
import lxm.designMode.factory_工厂模式.简单工厂.Car;
import lxm.designMode.factory_工厂模式.简单工厂.Moveable;
import lxm.designMode.factory_工厂模式.简单工厂.Plane;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        Plane plane = new Plane();
//        plane.go();
        Moveable car = new Car();
        car.go();
        Plane plane = new Plane();
        plane.go();


        CarFactory carFactory = new CarFactory();
        carFactory.create().go();

    }
}
