package lxm.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author: liangxm
 * @Date: 2020/5/23 - 05 - 23 - 13:53
 * @Description: lxm.jdk8.lambda
 * @version: 1.0
 */
public class V1_apple {
    public static void main(String[] args) {
        List<Apple> checkList = new ArrayList<>();
        checkList.add( new Apple().setColor("green").setWeight(100));
        checkList.add( new Apple().setColor("red").setWeight(60));
        checkList.add( new Apple().setColor("red").setWeight(80));

        /**
         * V1 将方法当做参数传值 Apple::isGreenApple
         */
        filterApples(checkList, Apple::isGreenApple);
        filterApples(checkList,Apple::checkWeight);

        /**
         * V2 直接用lanmbda  (Apple apple) ->"green".equals(apple.getColor())
         */
        filterApples(checkList,(Apple apple) ->"green".equals(apple.getColor()));
        filterApples(checkList,(Apple apple) -> "red".equals(apple.getColor()) || apple.getWeight()>100);

        /**
         * V3 直接调用类库
         */
//        filter(checkList,(Apple apple) -> "greent".equals(apple.getColor()));

        /**
         * V4 用stream和lanmbda 顺序处理 ，即串行处理，用到一个CPU
         * checkList.stream()
         */
        List<Apple> collect = checkList.stream().filter(
                (Apple a) -> a.getWeight() > 60).collect(toList());
        System.out.println("stream:"+collect);

        /**
         * V5 用stream和lanmbda 顺序处理 ，
         * 即并行处理，将filter分支到两个CPU上并聚合结果
         * checkList.parallelStream()
         */
        List<Apple> collect1 = checkList.parallelStream().filter(
                (Apple a) -> a.getWeight() > 60).collect(toList());
        System.out.println("parallelStream:"+collect1);

        /**
         * V6 list 过滤之后 转换为set输出
         */
        Set<Apple> collect2 = checkList.parallelStream().filter(
                (Apple a) -> a.getWeight() > 60  ).collect(toSet());
        System.out.println("toSet():"+collect2);

        /**
         * V6 checkList.sort 根据重量排序
         */
        checkList.sort((o1,o2)->{
            if (o1.getWeight()==(o2.getWeight())) {
                return 0;
            } else if (o1.getWeight() > o2.getWeight()) {
                //o2为前值，o1为后值；这里理解为：后值比前值大，则不交换位置,等价从小到大排序
                //如果这里返回 -1，则为从大到小排序
                return 1;
            } else {
                //后值比前值小，则交换位置
                return -1;
            }
        });
        checkList.forEach(e -> System.out.print(e+" "));
    }


    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){

        ArrayList<Apple> result = new ArrayList<>();
        inventory.forEach(apple -> {
            if(p.test(apple)){
                result.add(apple);
            }
        } );
        System.out.println(result);
        return result;
    }

//    static <T> Collection<T> filter(Collection<T> c, Predicate<T> p);
}

class Apple{
    private String color;
    private int weight;


    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean checkWeight(Apple apple){
        return apple.getWeight()>60;
    }

    public String getColor() {
        return color;
    }

    public Apple setColor(String color) {
        this.color = color;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Apple setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}