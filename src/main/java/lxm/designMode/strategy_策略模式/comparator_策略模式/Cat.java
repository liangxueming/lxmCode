package lxm.designMode.strategy_策略模式.comparator_策略模式;

public class Cat implements Comparable<Cat> {
    int weight, hight;

    public Cat(int weight, int hight) {
        this.weight = weight;
        this.hight = hight;
    }

    @Override
    public int compareTo(Cat c) {
        if(this.weight<c.weight){
            return -1;
        }else if (this.weight>c.weight){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", hight=" + hight +
                '}';
    }
}
