package com.leetcode.cn.algorithm.cn;

import java.util.*;

/**
 * Created by Administrator on 2019/12/30.
 */
public class Greedy {

    public static void main(String[] args) {
        Map<String, HashSet<String>> broasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broasts.put("Key1", hashSet1);
        broasts.put("Key2", hashSet2);
        broasts.put("Key3", hashSet3);
        broasts.put("Key4", hashSet4);
        broasts.put("Key5", hashSet5);

        //放最后的集合
        List<String> list = new ArrayList<>();
        //放总的集合
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<String, HashSet<String>> entry : broasts.entrySet()) {
            HashSet<String> value = entry.getValue();
            set.addAll(value);
        }
        //set.addAll(Arrays.asList("成都", "上海", "广州", "天津", "大连", "杭州", "北京", "深圳"));
        //System.out.println(set);
        HashSet<String> tempSet = new HashSet<>();
        String maxKey;
        while (set.size() != 0) {

            maxKey = null;
            for (String key : broasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(set);

                //求局部最优，这里使用贪心算法 tempSet.size() > broasts.get(maxKey).size())
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                list.add(maxKey);
                set.removeAll(broasts.get(maxKey));
            }
        }
        System.out.println(list);
    }
}
