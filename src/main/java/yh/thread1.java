package yh;

import java.util.function.Function;

public class thread1 {
    public static void main(String[] args) {
        tickets tic=new tickets();
        int i=10;
        while (i>0){
            Thread t1 = new Thread(() -> {
                try {
                    tic.sale3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
            i--;
        }

    }
}
