package threadCreationMethods;

public class ThreadExtends extends Thread{

    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("This is the thread created from extending the thread class "+ i );
        }
    }
}
