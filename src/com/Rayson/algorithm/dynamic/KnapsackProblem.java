package com.Rayson.algorithm.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int w[] = {1, 4, 3};//物品重量
        int v[] = {1500, 3000, 2000};//物品价值
        int m = 4;//背包容量
        int n = v.length;//物品的个数
        int[][] val = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        //初始化第一行第一列
        for (int i = 0; i < val.length; i++) {
            val[i][0] = 0;
        }
        for (int i = 0; i < val[0].length; i++) {
            val[0][i] = 0;
        }
        for (int i = 1; i < val.length; i++) {
            for (int j = 1; j < val[0].length; j++) {
                if (w[i - 1] > j) {
                    val[i][j] = val[i - 1][j];
                }
                else {
                    //val[i][j] = Math.max(val[i - 1][j], v[i - 1] + val[i - 1][j - w[i - 1]]);
                    if (val[i - 1][j] > (v[i - 1] + val[i - 1][j - w[i - 1]])) {
                        val[i][j] = val[i - 1][j];
                    }
                    else {
                        val[i][j] = v[i - 1] + val[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[0].length; j++) {

            }
        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品放入");
                j -= w[i - 1];
            }
            i--;
        }
    }

}
