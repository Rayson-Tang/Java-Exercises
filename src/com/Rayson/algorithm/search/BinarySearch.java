package com.Rayson.algorithm.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int[]arr = {1,8,9,55,55,55,55,66,78,999};
        ArrayList<Integer> i = binarySearch(arr, 0, arr.length - 1, 55);
        System.out.println(i);
    }

    public static ArrayList<Integer> binarySearch(int[]arr, int left, int right, int val){
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2;
        if (val > arr[mid]){
            return binarySearch(arr, mid + 1, right, val);
        }else if (val < arr[mid]){
            return binarySearch(arr, left, mid - 1, val);
        }else {
            //return mid;
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (arr[temp] != val){
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true){
                if (arr[temp] != val){
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
