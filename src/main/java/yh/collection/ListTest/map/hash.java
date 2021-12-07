package yh.collection.ListTest.map;

import java.util.HashMap;

public class hash {
    public static void main(String[] args) {
        HashMap<String,String> mapp = new HashMap<>(16);
        mapp.put("a", "1234a");
        mapp.put("b", "1234b");
        mapp.put("c", "1234c");

        //keySet()key集，values() value集
        mapp.forEach((key,value)-> {
            key=key+1;
            System.out.println(key);
        });





    }
}
