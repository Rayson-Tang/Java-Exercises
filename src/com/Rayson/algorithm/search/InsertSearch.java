package com.Rayson.algorithm.search;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int i = insertSearch(arr, 0, arr.length - 1, 99);
        System.out.println(i);
    }

    public static int insertSearch(int[]arr, int left, int right, int val){
        //判断为了防止mid越界
        if (left > right || val < arr[0] || val > arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
        if (val < arr[mid]){
            return insertSearch(arr, left, mid - 1, val);
        }else if (val > arr[mid]){
            return insertSearch(arr, mid + 1, right, val);
        }else {
            return mid;
        }
    }
}
