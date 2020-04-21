package lxm.designMode.chain_责任链;

import java.util.ArrayList;

/**
 * chain Of Responsibility 责任链
 */
public class Main {
    public static void main(String[] args) {
        Msg msg= new Msg();
        msg.setMsg("大家好：）<script>欢迎来到程序员的世界</script>，他们都是996！");

        //第一个链条
        FilterChain fc=new FilterChain();
        fc.add(new HtmlFilter()).add(new SensitiveFilter());

        //第二个链条
        FilterChain fc2=new FilterChain();
        fc2.add(new FaceFilter());

        fc.add(fc2);
        fc.doFilter(msg);

        System.out.println(msg.getMsg());
    }
}

/**
 * 也实现Filter接口
 */
class FilterChain implements Filter{
    ArrayList<Filter> filters= new ArrayList<>();
    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    //有一个链条返回false,则不往下执行
    public boolean doFilter(Msg m){
        for(Filter f:filters){
            if(!f.doFilter(m))return false;
        }
//        filters.forEach(filter -> {
//            if(!filter.doFilter(m)){
//                return false;
//            }
//        });
        return true;
    }

}

class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replaceAll("：）", "::>>");
        m.setMsg(msg);
        /**
         * 代码逻辑
         */
        return true;
    }
}

class HtmlFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replaceAll("<", "[");
        msg = msg.replaceAll(">", "]");
        m.setMsg(msg);
        /**
         * 代码逻辑
         */
        return true;
    }
}

class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replaceAll("996", "965");
        m.setMsg(msg);
        /**
         * 代码逻辑
         */
        return false;
    }
}

interface Filter{
    boolean doFilter(Msg m);
}

class Msg{
    String name ;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Msg{" +
                " msg='" + msg + '\'' +
                '}';
    }
}