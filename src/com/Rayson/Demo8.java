package com.Rayson;

import java.util.Arrays;

public class Demo8 {
    public static void main(String[] args) {
        int [] arr = {1,1,1,0};
        int i = threeSumClosest(arr, 100);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 100000000;
        int n = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int b = i + 1;
            int c = nums.length - 1;
            int sum;
            while (b < c && b < n && c < n) {
                sum = nums[i] + nums[b] + nums[c];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum < target) {
                    b++;
                }
                else {
                    c--;
                }
            }
        }
        return best;
    }
}

