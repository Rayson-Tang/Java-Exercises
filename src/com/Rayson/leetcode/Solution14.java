package com.Rayson.leetcode;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution14 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 3};
        Solution14 solution14 = new Solution14();
        solution14.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
