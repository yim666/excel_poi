package yh.collection.ListTest.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class tree {
    public static void main(String[] args) {
        TreeMap<Object, Object> map = new TreeMap<>();

        map.put("b", 27);
        map.put("c", 100);
        map.put("e", 10);
        map.put("d", 3);
        map.put("a", 39);

        System.out.println(map.values());
    }
}
