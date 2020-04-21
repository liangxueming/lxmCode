package lxm.designMode.strategy_策略模式.comparator_策略模式;

import java.util.Comparator;

public class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
      if(o1.dogPara1<o2.dogPara1)return -1;
      else if (o1.dogPara1>o2.dogPara1)return 1;
      else return 0;
    }
}
