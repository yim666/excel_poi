package yh;

public class base {
    static int age = 111;
    public static void main(String[] args) {

        age=999;
        System.out.println(age);
    }

    private static void modify(String age) {
        age="ppp";
    }
}
