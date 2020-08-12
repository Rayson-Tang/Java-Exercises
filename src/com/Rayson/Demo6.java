package com.Rayson;

import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int m = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int n = scanner.nextInt();
        int gcd = gcd(m, n);
        int lcm = lcm(m, n);
        System.out.println("最大公约数为：" + gcd);
       System.out.println("最小公倍数为：" + lcm);
    }

    public static int gcd(int m, int n) {
        int result = 0;
        if (m > n) {
            for (int i = n; i > 1; i++) {
                if (m % i == 0) {
                    result = i;
                    break;
                }
            }
        }
        else {
            for (int i = m; i > 1; i--) {
                if (m % i == 0 && n % i == 0) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static int lcm(int m, int n) {
        int result = 0;
        boolean flag = true;
        for (int i = 1; flag; i++) {
            for (int j = 1; j * n <= m * i; j++) {
                if (j * n == m * i) {
                    result = j * n;
                    flag = false;
                    break;
                }
            }
        }
        return result;
    }
}
