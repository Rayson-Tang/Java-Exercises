package com.Rayson.dataStructures.recursion;

import java.util.LinkedList;

public class MiGong {
    public static void main(String[] args) {
        int[][] ints = new int[8][7];
        //上下置为1
        for (int i = 0; i < 7; i++) {
            ints[0][i] = 1;
            ints[7][i] = 1;
        }
        //左右置为1
        for (int i = 0; i < 8; i++) {
            ints[i][0] = 1;
            ints[i][6] = 1;
        }
        ints[3][1] = 1;
        ints[3][2] = 1;
        setWay(ints, 1, 1);
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
    //找路方法
    //i,j为出发点
    //到达[6][5]
    //0为未到达，1为墙，2为可以走，3为已经走过但不通
    //策略：下->右->上->左
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }
        else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map, i + 1, j)){
                    return true;
                }else if (setWay(map, i, j + 1)){
                    return true;
                }else if(setWay(map, i - 1, j)){
                    return true;
                }else if (setWay(map, i, j - 1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
