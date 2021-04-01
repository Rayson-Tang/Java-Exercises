package com.Rayson.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        Date d1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String s1 = simpleDateFormat.format(d1);
        shellSort(arr);
        Date d2 = new Date();
        String s2 = simpleDateFormat.format(d2);
        System.out.println(s1);
        System.out.println(s2);
    }
    public static void shellSort(int[]arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    public static void shellSort2(int[]arr){
        for (int gap = arr.length/2; gap > 0; gap /=2) {
            for (int i = gap; i < arr.length; i++) {

            }
        }
    }
}
