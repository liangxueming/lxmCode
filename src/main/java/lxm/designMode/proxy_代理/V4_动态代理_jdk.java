package lxm.designMode.proxy_代理;

import lxm.PubUtils.T;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author: liangxm
 * @Date: 2020/5/22 - 05 - 22 - 17:29
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 * 不灵活，被代理对象必须得实现一个接口
 *
 */
public class V4_动态代理_jdk {
    public static void main(String[] args) {
        Tank4 tank4 = new Tank4();
        //reflection 通过二进制字节码分析类的属性和方法
        Movable4 m = (Movable4)Proxy.newProxyInstance(Tank4.class.getClassLoader()
                , new Class[]{Movable4.class}
                , new LogHander(tank4));

        m.move();
    }
}
class LogHander implements InvocationHandler {
    Tank4 tank;
    public LogHander(Tank4 tank){
        this.tank=tank;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start..");
        Object o = method.invoke(tank, args);
        System.out.println("method " + method.getName() + " end!");
        return o;
    }
}
class Tank4 implements Movable4{

    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        T.sleep(new Random().nextInt(10000));
    }
}
interface Movable4{
    void move();
}
