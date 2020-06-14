package lxm.designMode.adapter_适配器;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author: liangxm
 * @Date: 2020/6/14 - 06 - 14 - 15:57
 * @Description: lxm.designMode.builder_构建器.adapter_适配器
 * @version: 1.0
 *
 * 接口转换器  Adapter  或者叫Wrapper
 */
public class Adapter {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("c:/test.text");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
