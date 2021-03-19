package com.Rayson.dataStructures.sparseArr;

import java.io.File;
import java.io.IOException;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建原始数组
        int arr[][] = new int[11][11];
        arr[2][3] = 1;
        arr[3][4] = 2;
        //输出原始数组
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        int line = 0;
        int row = 0;
        for (int[] rowArr : arr) {
            line++;
            for (int data : rowArr) {
                if (data != 0) {
                    sum++;
                }
                if (line == 1) {
                    row++;
                }

            }
        }
        System.out.println(sum);
        System.out.println(row);
        System.out.println(line);

        //创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = line;
        sparseArr[0][1] = row;
        sparseArr[0][2] = sum;
        int count = 1;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count++;
                }
            }

        }
        //输出稀疏数组
        for (int[] rowArr : sparseArr) {
            for (int data : rowArr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //恢复二维数
        int l;
        int r;
        int num;
        int arr2[][] = new  int [sparseArr[0][0]] [sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            l = sparseArr[i][0];
            r = sparseArr[i][1];
            num = sparseArr[i][2];
            arr2[l][r] = num;
        }

        for (int[] rowArr : arr2) {
            for (int data : rowArr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        File file = new File("sparseArr.txt");
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
