package org.example;

public class Singleton {
    private volatile static Singleton instance; //always the latest value will be read

    private Singleton() {
        System.out.println("the singleton is created");
    }

    private static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
