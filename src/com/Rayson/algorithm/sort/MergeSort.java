package com.Rayson.algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[]arr = {8,4,5,7,1,3,6,2};
    }
    //分+合
    public static void mergeSort(int[]arr, int left, int right, int[]temp){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    //分
    public static void merge(int[]arr, int left, int mid, int right, int[]temp){
        int i = left;//左边有序数据开始
        int j = mid + 1;//右边有序数据开始
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //剩余数据填入
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //拷贝temp
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
