package org.example;

public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate();

        Runnable mother = new Mother(plate);
        Runnable child = new Child(plate);

        Thread motherThread = new Thread(mother, "mother Thread");
        Thread childThread = new Thread (child, "child thread");
        //thread starts with the new state

        motherThread.start();
        childThread.start();
    }
}