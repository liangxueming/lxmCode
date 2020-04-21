package lxm.designMode.factory_工厂模式.抽象工厂;

/**
 * 武器  //shoot 射击
 */
public class AK47 extends Weapon {
    @Override
    public void shoot() {
        System.out.println("射击。。。。");
    }
}
