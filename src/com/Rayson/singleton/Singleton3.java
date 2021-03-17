package com.Rayson.singleton;

public class Singleton3 {
    private Singleton3(){

    }
    static Singleton3 Instance;
    public static Singleton3 getInstance() throws InterruptedException {
        synchronized (Singleton3.class){
            if (Instance == null){
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }


                Instance = new Singleton3();
            }
        }

        return Instance;
    }
}
