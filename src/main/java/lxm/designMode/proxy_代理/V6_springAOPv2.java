package lxm.designMode.proxy_代理;

import lxm.PubUtils.Log;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: liangxm
 * @Date: 2020/6/14 - 06 - 14 - 9:37
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 */
public class V6_springAOPv2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appV2.xml");
        Tank7 tank = (Tank7)context.getBean("tank");
        tank.move();
        tank.move2();
    }
}

class Tank7{
    public void move(){
        Log.print("move gogogo......");
    }
    public void move2(){
        Log.print("move2 gogogo......");
    }
}
@Aspect
class TimeProxy7{
    @Before("execution(void lxm.designMode.proxy_代理.Tank7.*())")
    public void before(){
        Log.print("before......");
    }
    @After("execution(void lxm.designMode.proxy_代理.Tank7.*())")
    public void after(){
        Log.print("after......");
    }
}