package org.example;

public class Plate {

    private String food;
    private boolean available = false ;

    public Plate(String food, Boolean available){
        this.food = food;
        this.available = available;
    }
    public Plate(){

    }

    public synchronized void putFood(String food){
        while (available ){
            try {
                wait();  //RUNNABLE to WAITING state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.food = food;
        System.out.println(Thread.currentThread().getName()+ "serves"+ food);
        available = true;
        notifyAll(); //WAITING to RUNNABLE
    }


    public synchronized String getFood(){
        while(!available){
            try {
                wait(); //RUNNABLE To WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        System.out.println(Thread.currentThread().getName()+ "serves"+ food);
        return food;
    }
}
