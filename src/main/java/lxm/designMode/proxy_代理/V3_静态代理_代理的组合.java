package lxm.designMode.proxy_代理;

import java.util.Random;

/**
 * @author: liangxm
 * @Date: 2020/5/22 - 05 - 22 - 17:18
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 */
public class V3_静态代理_代理的组合 {
    public static void main(String[] args) {
        new Tank3LogProxy(
                new Tank3TimeProxy(
                        new Tank3())
        ).move();
    }
}
class Tank3LogProxy implements Movable3{
    Movable3 m;
    public Tank3LogProxy(Movable3 m){
        this.m=m;
    }
    @Override
    public void move() {
        System.out.println("tank start....");
        m.move();
        System.out.println("tank end");
    }
}
class Tank3TimeProxy implements Movable3{
    Movable3 m;
    public Tank3TimeProxy(Movable3 m){
        this.m=m;
    }
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }
}
class Tank3 implements Movable3{
    @Override
    public void move() {
        System.out.println("tank go ....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
interface Movable3{
    void move();
}