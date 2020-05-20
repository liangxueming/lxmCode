package lxm.designMode.observer_观察者;

import lxm.PubUtils.Log;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
class Child{
    private boolean cry=false;
    private List<Observer> observers=new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add((e)->{
            Log.print(e.timestamp,e.loc,e.source.getClass(),"lamda");
        });
    }
    public boolean isCry(){
        return cry;
    }

    /**
     * 醒了要干的事
     */
    public void wakeUp(){
        cry=true;
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(),"摇篮车里醒了",this);
        observers.forEach((o)->{
            o.actionOnWakeUp(event);
        });
    }

}

/**
 * 当前事件
 */
class WakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;
    @Override
    Child getSource() {
        return source;
    }

    /**
     * @param timestamp 当前时间
     * @param loc  位置
     * @param source   源对象
     */
    public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}
class Dad implements  Observer{

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        Log.print(event.timestamp,event.loc,event.source.getClass(),"孩子他爹");
    }
}
/**
 * 抽象事件
 * @param <T>
 */
abstract class Event<T>{
    abstract T getSource();
}

/**
 * 观察者接口
 */
interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}