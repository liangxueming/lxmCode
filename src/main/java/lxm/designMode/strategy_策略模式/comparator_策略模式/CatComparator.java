package lxm.designMode.strategy_策略模式.comparator_策略模式;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.weight<o2.weight){
            return -1;
        }else if (o1.weight>o2.weight){
            return 1;
        }else {
            return 0;
        }
    }
}
