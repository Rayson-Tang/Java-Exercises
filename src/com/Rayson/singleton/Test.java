package com.Rayson.singleton;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Singleton2 s1 = Singleton2.INSTANCE;
//        System.out.println(s1);

//        Singleton3 s3 = Singleton3.getInstance();
//        Singleton3 s4 = Singleton3.getInstance();
//        System.out.println(s3==s4);

        Callable<Singleton3> c = new Callable<Singleton3>(){

            @Override
            public Singleton3 call() throws Exception {
                return Singleton3.getInstance();
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton3> f1 = es.submit(c);
        Future<Singleton3> f2 = es.submit(c);

        Singleton3 s1 = f1.get();
        Singleton3 s2 = f2.get();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);

        es.shutdown();
    }
}
