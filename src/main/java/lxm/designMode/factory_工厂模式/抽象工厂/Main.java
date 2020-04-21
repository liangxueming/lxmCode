package lxm.designMode.factory_工厂模式.抽象工厂;

/**
 * 产品族
 *      人类
 *      外星人
 *      未知生物
 *
 *  此demo分为两个产品族，两个维度
 *                               交通工具（Vehicle）    武器类（Weapon）       食物类（Food）
 *  ModernFactory 现代人工厂        Car                       AK47                  Bread
 *  MagicFactory  外星人工厂        Broom                     MagicStick            MushRoom
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();
        AK47 ak47 = new AK47();
        ak47.shoot();
        Bread bread = new Bread();
        bread.printName();

        AbastraFactory modernFactory = new ModernFactory();
        modernFactory.crearVehicle().go();
        modernFactory.createFood().printName();
        modernFactory.createWeapon().shoot();

        AbastraFactory magicFactory = new MagicFactory();
        magicFactory.createWeapon().shoot();
        magicFactory.createFood().printName();
        magicFactory.crearVehicle().go();

//        Class.forName();
    }
}
