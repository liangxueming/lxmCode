package lxm.designMode.proxy_代理;

import java.util.Random;

/**
 * @author: liangxm
 * @Date: 2020/5/22 - 05 - 22 - 16:53
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 *
 * 不灵活
 */
public class V1_静态代理 {
    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
    }
}

/**
 * 代理
 */
class TankTimeProxy implements Movable{
    Tank tank;

    /**
     * tank不推介将tank 传为参数
     * @param tank
     */
    public TankTimeProxy(Tank tank){
        this.tank=tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("Tank  go........");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface Movable{
    void move();
}