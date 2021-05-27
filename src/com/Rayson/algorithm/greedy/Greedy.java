package com.Rayson.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("天津");
        hashSet4.add("上海");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);
        HashSet<String> all = new HashSet<>();
        for (HashSet<String> hashSet : broadcasts.values()) {
            for (String str : hashSet) {
                if (!all.contains(str)) {
                    all.add(str);
                }
            }
        }
        System.out.println(all);
        ArrayList<String> select = new ArrayList<>();
        HashSet<String> temp = new HashSet<>();
        String maxKey = null;
        while (all.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                temp.clear();
                HashSet<String> areas = broadcasts.get(key);
                temp.addAll(areas);
                temp.retainAll(all);
                if (temp.size() != 0 && (maxKey == null || (temp.size() > broadcasts.get(maxKey).size()))) {
                    maxKey = key;
                    System.out.print(temp.size() + " ");
                    //System.out.println(maxKey);
                    if (maxKey != null) {
                        System.out.print(broadcasts.get(maxKey).size());
                    }
                    System.out.println();

                }
            }
            if (maxKey != null) {
                select.add(maxKey);
                all.removeAll(broadcasts.get(maxKey));
            }
            System.out.println(select);
        }
    }

}
