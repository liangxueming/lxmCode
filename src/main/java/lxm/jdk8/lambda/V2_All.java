package lxm.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate  谓语，述语  使……基于；断言；暗示
 * 将list 类型抽象化  !!! 灵活，简洁
 */
public class V2_All {
    public static void main(String[] args) {
        List<Apple> checkList = new ArrayList<>();
        checkList.add( new Apple().setColor("green").setWeight(100));
        checkList.add( new Apple().setColor("red").setWeight(60));
        checkList.add( new Apple().setColor("red").setWeight(80));

        filter(checkList,(Apple a)-> "red".equals(a.getColor()));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); numbers.add(2); numbers.add(3); numbers.add(4); numbers.add(5);
        /**
         * V1 实现Predicate<T>接口
         */
        filter(numbers,new Test());
        /**
         * V2 匿名类 Predicate<Integer>
         */
        filter(numbers,new Predicate<Integer>() {
            //方法名必须和Predicate接口里定义的方法名一样
            public boolean test(Integer i) {
                return i % 1==0;
            }
        });
        /**
         * V3 lanmbda
         */
        filter(numbers,(Integer i) ->  i % 2==0);
        filter(numbers,(Integer i) ->{return i%2==0;});

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        ArrayList<T> result = new ArrayList<>();
        for (T e : list) {
            if(p.test(e)){
                result.add(e);
            }
        }
        System.out.println(result);
        return result ;
    }
}
/**
 * FunctionalInterface
 * @param <T>
 */
//@FunctionalInterface
//interface Predicate<T> {
//    boolean test(T t);
//}
class Test implements Predicate<Integer>{

    @Override
    public boolean test(Integer i) {
        return i % 2==0;
    }
}