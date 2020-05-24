package lxm.jdk8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Predicate<T>  boolean  test();
 * Consumer<T>  void accept();
 * Function<T, R>  apply ()
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {

        String result=BufferedReaderProessor.processFile((BufferedReader br)->
                br.readLine()+" "+br.readLine()+" "+br.readLine());
        System.out.println("result "+result);

        /**
         * lanmbda是Consumer接口中accept()方法的实现
         */
        forEach(Arrays.asList(3,4,1,2,5,7),(Integer i) -> System.out.println(i));

        /**
         * lanmbda是Function接口apply方法的实现
         */
        map(Arrays.asList("123","Function","lanmbda"),(String s)-> s+".length():"+s.length());

    }
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        ArrayList<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        System.out.println("map():" + result.toString());
        return result;
    }

    public static <T> void forEach(List<T> list,Consumer<T> c){
        for (T t : list) {
            c.accept(t);
        }
    }
}

@FunctionalInterface
interface BufferedReaderProessor{
    String process(BufferedReader br) throws IOException;

    public static String processFile(BufferedReaderProessor p) throws IOException {
        try (BufferedReader br =new BufferedReader(
                new FileReader("C://Users/Administrator/Desktop/test.txt"))){
            return p.process(br);
        }
    }
}
