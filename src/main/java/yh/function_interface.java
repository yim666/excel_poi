package yh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class function_interface {
    public static void main(String[] args) {

        //Function<T,R>函数式接口  传入T类型参数   返回R类型参数
        Function<String,String> function=s -> {
            return s+666;
        };
        System.out.println(function.apply("ss"));;

        //传入两个参数，返回一个
//        BiFunction<String,String,Integer> biFunction= (s1,s2) -> {
//            return s1.length()+s2.length();
//        };
//        System.out.println(biFunction.apply("ss", "aaaa"));

        //Consumer<T>  传入T类型参数  不返回值
        Consumer<String> consumer=s -> {
            System.out.println("666");
        };

        //Predicate<T> 传入T类型参数  返回Boolean类型
        Predicate<String> predicate =s -> {
          return s.equals(10);
        };
        Predicate<String> p=String::isEmpty;
        System.out.println(p.test(""));

        //Supplier<T> 不传入参数   返回T类型参数
        Supplier<String> supplier=()-> {
                return "ssss";
        };

        List<String> list = Arrays.asList("aa", "bbb", "cc");
        list.stream()  //stream流 stream()  + 0~n个中间操作   + 1个终端操作
                //中间操作往往是对集合元素本身进行一些处理或者转换，比如：过滤、排序等操作。
                // 终端操作一般是用来得到结果的，比如计数、各种处理后的列表等
                .map(v->v+1)//Function<T,R> map映射
                .filter(a->a.length()>2)
                //forEach(System.out::println);
                .forEach(v-> System.out.println(v)); //Consumer<T> 遍历

        List<String> testList = Arrays.asList ("a", "b", "A", "B");
//        testList.sort ((s1, s2) -> s1.compareToIgnoreCase (s2));
        testList.sort (String::compareToIgnoreCase);
        System.out.println (testList);

        //8.concat 静态方法,合并两个流
        Stream<String> ss1 = Stream.of("jack","rose");
        Stream<String> ss2  = Stream.of("tom","lucy");
//静态方法
        Stream<String> sss = Stream.concat(ss1,ss2);
        sss.forEach(s-> System.out.print(s+" "));


    }
}
