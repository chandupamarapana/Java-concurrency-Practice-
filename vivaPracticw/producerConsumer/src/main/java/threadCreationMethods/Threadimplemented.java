package threadCreationMethods;

public class Threadimplemented implements Runnable{

    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("This is the thread that is implemented from a runnable "+ i);
        }
    }
}
