package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plate {

    private String food;
    private boolean available = false ;

    private final Lock lock = new ReentrantLock(true);
    private final Condition notFull = lock.newCondition(); //for the consumers.

    private final Condition notEmpty = lock.newCondition(); //for the producer



    public Plate(String food, Boolean available){
        this.food = food;
        this.available = available;
    }
    public Plate(){

    }

    public void putFood(String food){

        try{
            lock.lock();
            while (available ){
                try {
                    notEmpty.await();  //RUNNABLE to WAITING state
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        this.food = food;
        System.out.println(Thread.currentThread().getName()+ "serves"+ food);
        available = true;
        notFull.signalAll(); //WAITING to RUNNABLE
    }
        finally {
            lock.unlock();
        }
        }


    public String getFood(){
        try{
            lock.lock();
            while(!available){
                try {
                    notFull.await(); //RUNNABLE To WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        available = false;
        notEmpty.signalAll();
        System.out.println(Thread.currentThread().getName()+ "serves"+ food);
        return food;
    }
        finally {
            lock.unlock();
        }
        }
}
