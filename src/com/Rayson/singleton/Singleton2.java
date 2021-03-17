package com.Rayson.singleton;

import java.io.IOException;
import java.util.Properties;

public class Singleton2 {
    private Singleton2(String info){
        this.info = info;
    }
    private String info;

    public String getInfo() {
        return info;
    }

    public final static Singleton2 INSTANCE;
    static {

        try {
            Properties pro = new Properties();
            pro.load(Singleton2.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton2(pro.getProperty("info"));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
