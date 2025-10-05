package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread myThread = new MyThread("Thread1");//thread enters into the NEW state
//        myThread.run(); // run method here runs on the main thread
        // if you want to bring myThread into RUNNABLE state then you musr be calling the start method

        myThread.start();
        Runnable myRunnable = new MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable, "Runnable Thread");
        myRunnableThread.start();

        //multithreading using lambda function
        Thread thread3 = new Thread(() -> {
            for (int i = 0 ; i<=10; i++){
                System.out.println(Thread.currentThread().getName() + ": "+ i);
            }
        }, "lambda Thread 3 ");
        thread3.start();
        Thread thread4 = new Thread(new MyRunnable(){
            @Override
           public void run() {
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        },"thread 5 anonymous inner class");
        thread4.start();




    }
}