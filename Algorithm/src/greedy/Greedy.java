package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> set_1 = new HashSet<>();
        HashSet<String> set_2 = new HashSet<>();
        HashSet<String> set_3 = new HashSet<>();
        HashSet<String> set_4 = new HashSet<>();
        HashSet<String> set_5 = new HashSet<>();
        set_1.add("北京");
        set_1.add("上海");
        set_1.add("天津");
        set_2.add("广州");
        set_2.add("北京");
        set_2.add("深圳");
        set_3.add("成都");
        set_3.add("上海");
        set_3.add("杭州");
        set_4.add("上海");
        set_4.add("天津");
        set_5.add("杭州");
        set_5.add("大连");
        broadcasts.put("k1",set_1);
        broadcasts.put("k2",set_2);
        broadcasts.put("k3",set_3);
        broadcasts.put("k4",set_4);
        broadcasts.put("k5",set_5);
        // 定义最大存储
        String maxKey = null;
        ArrayList list = new ArrayList();
        // 定义总共区域
        HashSet<String> allAreas = new HashSet<>();
        HashSet<String> tempAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");


        // 当总区域大小为 0 时刻 说明 已选举好
        while (allAreas.size() > 0){
            maxKey = null; // 最大制空
            // 遍历
            for (String key:broadcasts.keySet()){
                tempAreas.clear(); // 清除临时区域
                HashSet<String> areas  = broadcasts.get(key); // 获得当前key 对应的城市
                tempAreas.addAll(areas); // 保存到临时区域中
                tempAreas.retainAll(allAreas); // 取并集给 tempAreas 临时区域
                // 满足条件1：临时区域大于 0 说明该key 可以被选择
                // 满足条件2 ： maxKey 为空 说明还未选择 将当前key 先赋值给maxKey
                //              或者 判断当前临时区域可覆盖的长度 是否大于最大覆盖城市长度
                //            是 则 替换maxKey
                if (tempAreas.size() > 0 &&
                        (maxKey == null || tempAreas.size() > broadcasts.get(maxKey).size())
                ) {
                    maxKey = key;
                }
            }

            // 判断 是否存在
            if(maxKey != null){
                // 不为空 说明找到可以替换的
                list.add(maxKey); // 加到list中去
                allAreas.removeAll(broadcasts.get(maxKey));// 清除当前对应的区域
            }
        }

        System.out.println(list);
    }
}
