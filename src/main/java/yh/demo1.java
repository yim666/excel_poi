package yh;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {

//        List<String> all = new ArrayList<>();//此时集合里面只适合保存String类型数据
//        all.add("Hello");
//        all.add("Hello");	//重复数据
//        all.add("a");
//        all.add("world~!");
//
//        Iterator<String> iter = all.iterator();//实例化Iterator
//        while(iter.hasNext()){
//            String str = iter.next();
//            if("a".equals(str)){
//                iter.remove();//如果不中断后续输出，则执行
////                continue ;
//            }
//            System.out.println(str);
//        }
//        System.out.println(all);

        Map<Integer,String> map = new HashMap<>();
        map.put(1, "hELLO,");
        map.put(2, "WORLD!!!");
        //1.将map变为Set集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //2.实例化Iterator接口
        Iterator<Map.Entry<Integer, String>> iter = set.iterator();
        //3.迭代输出每一个Map.Entry对象
        while(iter.hasNext()){
            //4.取出Map.Entry
            Map.Entry<Integer, String> me = iter.next();
            //5.取得key和value
            System.out.println(me.getKey() + "=" + me.getValue());
        }


    }


}
