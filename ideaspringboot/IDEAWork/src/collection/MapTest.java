package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther:chaijunjie
 * @Date:2019/10/28
 * @Description:collection
 * @version:1.0
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"s");
        map.put(2,"ss");
        map.put(3,"sss");
        map.put(4,"ssss");
        map.put(5,"sssss");
        map.put(6,"ssssss");
        map.put(7,"sssssss");
        for(Integer key:map.keySet()){//第一种：得到所有的key.
            System.out.println(map.get(key));
        }
        for(String key:map.values()){//第二种：得到所有的值.
            System.out.println(key);
        }
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();//得到所有的entry对象
        for (Map.Entry<Integer, String> s:
        entrySet) {
            System.out.println(s.getKey()+s.getValue());
        }
    }
}
