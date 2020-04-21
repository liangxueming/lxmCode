package lxm.designMode.factory_工厂模式.工厂方法;

import lxm.designMode.factory_工厂模式.简单工厂.Car;

public class CarFactory {
    public Car create(){
        /**
         * 这里可以加处理
         */
        System.out.println(" CarFactory create...");
        return new Car();
    }
}
