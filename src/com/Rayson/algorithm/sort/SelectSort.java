package com.Rayson.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {2, 8, 1, 6, 4};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        Date d1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String s1 = simpleDateFormat.format(d1);
        selectSort(arr);
        Date d2 = new Date();
        String s2 = simpleDateFormat.format(d2);
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void selectSort(int[] arr) {
        int minIndex = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.print(i + 1 + ":");
//            System.out.print(Arrays.toString(arr));
//            System.out.println(min);
        }
    }
}
