package lxm.designMode.factory_工厂模式.简单工厂;

/**
 * 简单的，扩展性不好
 *
 * Vehicle 交通工具
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        /**
         * 中间可以加处理
         */
        return new Car();
    }

    public Plane createPlane(){

        return new Plane();
    }
}
