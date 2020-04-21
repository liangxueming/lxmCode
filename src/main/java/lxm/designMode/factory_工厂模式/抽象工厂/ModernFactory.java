package lxm.designMode.factory_工厂模式.抽象工厂;

/**
 * 现代人工厂
 */
public class ModernFactory extends AbastraFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle crearVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
