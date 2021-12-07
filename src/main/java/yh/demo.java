package yh;

import java.lang.reflect.Field;
import java.util.*;


public class demo {
    public static void main(String[] args) {

//        Set<Integer> test = new HashSet<>();
//        ArrayList<Object> o = new ArrayList<>();
        HashSet<Object> o = new HashSet<>();
        HashSet<Object> b = new HashSet<>();
        System.out.println(o.add(1));
        System.out.println(o.add(1));
        o.add("adas");
        o.add(1.22);
        o.add(1.22);
        int[] ints = {1, 2, 34};
        o.add(ints);
        b.add(1);
        b.add(1.22);
        b.add("ss");
//        o.removeAll(b);
        o.addAll(b);
        System.out.println(o);
        Iterator it = o.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Integer) {
                System.out.println("Integer:" + obj);
            }
            if (obj instanceof Double ) {
                System.out.println("Double:" + obj);
            }
            if (obj instanceof String) {
                System.out.println("String:" + obj);
            }
            if (obj instanceof Character) {
                System.out.println("Character:" + obj);
            }
            if (obj instanceof int[]) {
                System.out.print("int[]:");
                for (int i = 0; i < ints.length; i++) {
                    System.out.print(ints[i] + " ");
                }
            }

        }
    }
}
