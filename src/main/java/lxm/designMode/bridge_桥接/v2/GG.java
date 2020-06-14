package lxm.designMode.bridge_桥接.v2;

public class GG {
    public void chase(MM mm) {
        Gift g = new Book();
        give(mm, g);
    }

    public void give(MM mm, Gift g) {

    }

    public static void main(String[] args) {
        new GG().chase(new MM());
    }
}
