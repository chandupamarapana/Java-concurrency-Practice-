package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plate {

    private BlockingQueue foodQueue = new ArrayBlockingQueue(1);


    public Plate() {

    }

    public void putFood(String food) {
        try {
            foodQueue.put(food);
            System.out.println(Thread.currentThread().getName() + "Eat " + food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getFood() {
        try {
            String food = (String) foodQueue.take();
            System.out.println(Thread.currentThread().getName() + "Consume " + food);
            return food;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
