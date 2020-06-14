package lxm.designMode.bridge_桥接.v4;

public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    public void give(MM mm, Gift g) {
        System.out.println(mm.name +"收到： "+g + "  gived!");
    }

    public static void main(String[] args) {
        new GG().chase(new MM("57"));
    }
}
