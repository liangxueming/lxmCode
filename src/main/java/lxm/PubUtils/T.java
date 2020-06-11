package lxm.PubUtils;

/**
 * @author: liangxm
 * @Date: 2020/6/11 - 06 - 11 - 21:43
 * @Description: lxm.PubUtils
 * @version: 1.0
 */
public class T {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
