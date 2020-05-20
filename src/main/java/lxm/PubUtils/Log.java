package lxm.PubUtils;

public class Log {
    public static void main(String[] args) {

        print("A", "b", "c");


    }

    public static void print(Object... args) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            sb.append("%s\t");
        }
        System.out.println(Thread.currentThread().getName() + " | " + String.format(sb.toString(), args));
    }
}
