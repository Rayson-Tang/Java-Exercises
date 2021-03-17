package com.Rayson.singleton;

public class Singleton4 {
    private Singleton4(){

    }

    public static class inner{
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return inner.INSTANCE;
    }
}
