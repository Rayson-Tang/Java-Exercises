package com.Rayson.singleton;

//1.构造器私有化
//2.静态变量
//3.自行创造
public class Singleton1 {
    private Singleton1(){

    }
   public static final Singleton1 INSTANCE = new Singleton1();
}
