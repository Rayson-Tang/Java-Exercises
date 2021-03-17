package com.Rayson.leetcode;

public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.fbnq(6));

    }

    public Integer fbnq (int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else {
            return fbnq(n-1)+fbnq(n-2);
        }
    }
}
