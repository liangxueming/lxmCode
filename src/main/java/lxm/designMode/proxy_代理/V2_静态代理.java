package lxm.designMode.proxy_代理;

import java.util.Random;

import static lxm.PubUtils.T.sleep;

/**
 * @author: liangxm
 * @Date: 2020/5/22 - 05 - 22 - 17:04
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 * 推介
 */
public class V2_静态代理 {
    public static void main(String[] args) {

        new Tank2TimeProxy(new Tank2()).move();
    }
}

class Tank2TimeProxy implements  Movable2{
    Movable2 m;
    public Tank2TimeProxy (Movable2 m){
        this.m=m;
    }
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class Tank2 implements Movable2{

    @Override
    public void move() {
        System.out.println("Tank  go ......");
        sleep(new Random().nextInt(10000));
    }
}

interface Movable2{
    void move();
}

