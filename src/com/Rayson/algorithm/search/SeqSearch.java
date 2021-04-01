package com.Rayson.algorithm.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[]arr = {1,5,1,9,5,7,3};
        int i = seqSearch(arr, 1);
        System.out.println(i);
    }

    public static int seqSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
