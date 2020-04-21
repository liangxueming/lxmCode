package lxm.designMode.strategy_策略模式.comparator_策略模式;

import java.util.Comparator;

/**
 * 冒泡排序
 * 泛型， 必须传入T 类型的比较器
 */
public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
//                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
                int compare = comparator.compare(arr[j], arr[minPos]);
                if(compare==-1){
                    minPos = j;
                }

            }
            swap(arr, i, minPos);
        }
    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
