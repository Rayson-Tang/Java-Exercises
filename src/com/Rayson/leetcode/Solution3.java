package com.Rayson.leetcode;

import java.util.ArrayList;

public class Solution3 {
    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        while (list.size() > 2) {
            int max = 0, min = 0;
            for (int i = 0; i < list.size(); i++) {
                if (max < list.get(i)) {
                    max = list.get(i);
                }
                if (min > list.get(i)) {
                    min = list.get(i);
                }
            }
            list.remove(max);
        }
    }
}
