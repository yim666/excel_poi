package yh;

public class jdk8_default {
    public static void main(String[] args) {
        teenager t= new teenager();
        t.a();

        boy b=()-> System.out.println("boy");
        b.b();
    }
}

interface boy{
    void b();
     default void a(){
        System.out.println("boy_a");
    }

}

interface girl{
    default void a(){
        System.out.println("girl_a");
    }

}

class teenager implements boy,girl{

    @Override
    public void b() {

    }

    @Override
    public void a() {
    boy.super.a();
    girl.super.a();
    }
}
