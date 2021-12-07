package yh.collection.ListTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class array {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(13);
//        Iterator<Integer> it = list.iterator();
        ListIterator<Integer> it = list.listIterator();
        it.next();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());//迭代器指针右移，看左边的元素
        System.out.println(it.previous());//迭代器左移，看右边的元素
        System.out.println(it.previous());
        System.out.println("=================");
        list.remove(1);
        System.out.println(list);
    }
}
