package com.Rayson.leetcode;

//盛最多水的容器

public class Solution7 {
    public static void main(String[] args) {
        int[] ints = {1,8,6,2,5,4,8,3,7};
        Solution7 solution7 = new Solution7();
        int max = solution7.maxArea(ints);
        System.out.println(max);
    }
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;
    }
}
