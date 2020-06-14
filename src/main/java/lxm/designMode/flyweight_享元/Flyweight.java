package lxm.designMode.flyweight_享元;

import lxm.PubUtils.Log;
import lxm.PubUtils.T;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: liangxm
 * @Date: 2020/6/14 - 06 - 14 - 13:48
 * @Description: lxm.designMode.flyweight_享元
 * @version: 1.0
 *
 * 重复利用对象、共享元数据
 */
public class Flyweight {
    public static void main(String[] args) {
        BulletPool bp = new BulletPool();
        while(true){
            new Thread(()->{
                Bullet b = bp.getBullet();
                b.setLiving(false);
                T.sleep(10);
            }).start();
        }
    }
}
class BulletPool{
    List<Bullet> bullets = new ArrayList<>();
    {
        for(int i=0;i<5;i++){
            Log.print("=========添加对象========");
            bullets.add(new Bullet());
        }
    }
    public Bullet getBullet(){
        for (int i=0;i<bullets.size();i++){
            Bullet bullet = bullets.get(i);
            if(bullet.living) {
                Log.print("池子里有对象，拿一个");
                return bullet;
            }
        }
        Log.print("池子里没有对象了，需新创建一个");
        return new Bullet();
    }
}
class Bullet{
    public UUID id = UUID.randomUUID();
    volatile boolean living = true;

    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}