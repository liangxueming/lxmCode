package lxm.designMode.strategy_策略模式.comparator_策略模式;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] cArr= new Cat[]{new Cat(6, 1), new Cat(2, 1), new Cat(9,9)};

        Dog[] dogArr=new Dog[]{new Dog(2),new Dog(6),new Dog(1),new Dog(5)};

        Sorter<Cat> sorterCat = new Sorter<>();
        sorterCat.sort(cArr,new CatComparator());
        System.out.println(Arrays.toString(cArr));

//        Sorter<Dog> sorterDog = new Sorter<>();
//        sorterDog.sort(dogArr,new DogComparator());
//        System.out.println(Arrays.toString(dogArr));

        Sorter<Dog> sorterDog = new Sorter<Dog>();
        sorterDog.sort(dogArr,(o1,o2)->{
            if(o1.dogPara1<o2.dogPara1)return -1;
            else if (o1.dogPara1>o2.dogPara1)return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(dogArr));

        try {
            Sorter<Dog> sorterDog1  =(Sorter<Dog>)Class.forName("lxm.designMode.strategy_策略模式.comparator_策略模式.Sorter").newInstance();
            sorterDog1.sort(dogArr,new DogComparator());
            System.out.println(Arrays.toString(dogArr));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
