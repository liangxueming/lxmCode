package lxm.designMode.factory_工厂模式.抽象工厂;

/**
 * 外星人工厂
 */
public class MagicFactory extends AbastraFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle crearVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
