package lxm.designMode.strategy_策略模式.comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr={2,5,1,3,4,9,6};
//        Sorter.sort(arr);
        Cat[] cArr= new Cat[]{new Cat(6, 1), new Cat(2, 1), new Cat(9,9)};
        Sorter.sort(cArr);
        System.out.println(Arrays.toString(cArr));
    }
}
