package com.Rayson.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println("基数排序后 " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] count = new int[10];
        int bucketIndex = 0;
        boolean flag = true;
        for (int k = 1; flag; k *= 10) {

            for (int i = 0; i < arr.length; i++) {
                bucketIndex = arr[i] % (10 * k) / k;
                bucket[bucketIndex][count[bucketIndex]] = arr[i];
                count[bucketIndex]++;
            }
            int t = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (count[i] == arr.length){
                    flag = false;
                }
                for (int j = 0; j < count[i]; j++) {
                    arr[t++] = bucket[i][j];
                }
                count[i] = 0;
            }
        }
    }
}
