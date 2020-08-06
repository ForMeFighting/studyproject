package jdknew;

import java.util.concurrent.Callable;

/**
 * @Auther: 柴俊杰
 * @Description: jdknew jdk1.8 实现多线程
 * @Date: 2019/10/31 16:05
 * @version: 1.0
 */
public class LamBdaThread extends Thread{

    public static void main(String[] args) {

        new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("hello world"+i);
                    }
                }
        ).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "hello world");
            }
        }).start();

        Thread t = new Thread();
        t.interrupt();
//        t.start();
    }
}
