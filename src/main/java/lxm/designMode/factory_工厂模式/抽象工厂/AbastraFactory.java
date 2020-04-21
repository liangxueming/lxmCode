package lxm.designMode.factory_工厂模式.抽象工厂;

/**
 * 抽象工厂
 * 三个抽象的产品
 */
public abstract class AbastraFactory {
    abstract Food createFood();//食物
    abstract Vehicle crearVehicle();//交通工具
    abstract Weapon createWeapon();//武器
}
