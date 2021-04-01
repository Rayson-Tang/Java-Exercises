package com.Rayson.algorithm.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        //int[]nums = {1,2,3};
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random()*8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String s1 = simpleDateFormat.format(date1);
        bubbleSort(ints);
        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s1);
        System.out.println(s2);
    }
    public static void bubbleSort(int [] nums){
        int temp = 0;
        boolean flag = false;//是否交换
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
//            System.out.print(i+1 + ":");
//            System.out.println( Arrays.toString(nums));
            if (!flag){
                break;
            }

        }
    }
}
