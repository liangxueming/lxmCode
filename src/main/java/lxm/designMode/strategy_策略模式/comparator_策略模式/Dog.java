package lxm.designMode.strategy_策略模式.comparator_策略模式;


public class Dog implements Comparable<Dog> {
    int dogPara1 ;
    public Dog(int dogPara1){
        this.dogPara1=dogPara1;
    }

    @Override
    public int compareTo(Dog o) {
        if(this.dogPara1<o.dogPara1){
            return -1;
        }else if (this.dogPara1>o.dogPara1){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogPara1=" + dogPara1 +
                '}';
    }
}
