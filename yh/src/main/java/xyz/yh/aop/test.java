package xyz.yh.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class test {


    public static void main(String[] args) {

        Student s1 = new Student("小a",10);
        Student s2 = new Student("小b",20);
        swap(s1, s2);
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);

    }

//    改变的是x,y的引用地址的指向  x,y内容是拷贝的，但是地址始终是和s1,s2一样的
    public static void swap(Student x, Student y) { // x=小a  y=小b
        Student temp = x;
        x = y;
        y = temp;
        x.setAge(11);  //x=小b
        y.setAge(21);  //y=小a
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private String name;
    private Integer age;

}