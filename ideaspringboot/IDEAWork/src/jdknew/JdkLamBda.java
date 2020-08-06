package jdknew;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Auther: 柴俊杰
 * @Description: jdk1.8新特性
 * @Date: 2019/10/31 14:30
 * @version: 1.0
 */
public class JdkLamBda {
    public static void main(String[] args) {
        //jdk1.8之前的比较
        Comparator<Integer> cpt = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(t1,t2);
            }
        };
        TreeSet<Integer> set = new TreeSet<>(cpt);
        System.out.println("=========================");
        //使用LamBda表达式
        Comparator<Integer> cpt1 = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> set1 = new TreeSet<>();

        MathTest in = (int a,int b)->{ return a+b;};
        System.out.println(in);
    }

}
interface MathTest{
    int in(int a,int b);
}



































