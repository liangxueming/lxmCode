package lxm.designMode.strategy_策略模式.comparable;

/**
 *
 * @param <T> 泛型接口，子类实现时需指定自己的类型
 */
public interface Comparable <T>  {
    int compareTo(T o);
}
