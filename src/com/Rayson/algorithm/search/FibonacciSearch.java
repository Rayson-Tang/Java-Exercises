package com.Rayson.algorithm.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static void main(String[] args) {
        int [] arr = {1,5,8,9,10,55};
        int i = fibonacciSearch(arr, 5);
        System.out.println(i);
    }
    public static int fibonacciSearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fibonacci();//获取斐波那契数列
        while (high > f[k] - 1) {
            k++;
        }
        //f[k]可能大于原数组，拷贝，建立新数组
        int temp[] = Arrays.copyOf(arr,f[k]);
        for (int i = arr.length; i < f[k]; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = f[k - 1] - 1;
            if (val < temp[mid]){
                high = mid - 1;
                k--;
            }
            else if (val > temp[mid]) {
                low = mid + 1;
                k = k - 2;
            }else {
                if (high <= mid){
                    return high;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static int maxSize = 20;

    public static int[] fibonacci() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}
