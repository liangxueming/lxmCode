package lxm.designMode.proxy_代理;

import lxm.PubUtils.T;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author: liangxm
 * @Date: 2020/6/11 - 06 - 11 - 22:15
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 * CGLIB实现动态代理不需要接口
 */
public class V5_动态代理CGLIB {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank5.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank5 tank5 = (Tank5)enhancer.create();
        tank5.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass().getSuperclass().getName());

        System.out.println("before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}

class Tank5 {
    public void move() {
        System.out.println("Tank moving claclacla...");
        T.sleep(new Random().nextInt(10000));
    }
}