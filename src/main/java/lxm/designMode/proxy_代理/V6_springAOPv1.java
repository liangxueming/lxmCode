package lxm.designMode.proxy_代理;

import lxm.PubUtils.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: liangxm
 * @Date: 2020/6/14 - 06 - 14 - 9:37
 * @Description: lxm.designMode.proxy_代理
 * @version: 1.0
 */
public class V6_springAOPv1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank6 tank = (Tank6)context.getBean("tank");
        tank.move();
        tank.move2();
    }
}
class Tank6{
    public void move(){
        Log.print("move gogogo......");
    }
    public void move2(){
        Log.print("move2 gogogo......");
    }
}
class TimeProxy6{
    public void before(){
        Log.print("before......");
    }
    public void after(){
        Log.print("after......");
    }
}