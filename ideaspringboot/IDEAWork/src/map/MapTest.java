package map;

import java.util.*;

/**
 * @Auther: 柴俊杰
 * @Description: map
 * @Date: 2019/11/10 15:51
 * @version: 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        System.out.println();
        System.out.println();
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aa");
        map.put(2,"ss");
        map.put(3,"dd");
        map.put(4,"ff");
        map.put(5,"gg");
        map.put(6,"hh");
        map.put(7,"jj");
        Set<Integer> keyset = map.keySet();
        for (Integer i:keyset
             ) {
            System.out.println(map.get(i));
        }
        Collection<String> list=map.values();
        for (String i:list
        ) {
            System.out.println(i);
        }
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for (Map.Entry<Integer,String> ss:entrySet
             ) {
            System.out.println(ss.getKey()+ss.getValue());
        }
    }
}
