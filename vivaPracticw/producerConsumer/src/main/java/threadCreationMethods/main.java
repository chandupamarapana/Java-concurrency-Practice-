package threadCreationMethods;

public class main {
    public static void main(String[] args) {
        ThreadExtends threadOne = new ThreadExtends();

        threadOne.start();

        Threadimplemented threadimplemented = new Threadimplemented();
        Thread threadTwo = new Thread(threadimplemented);

        threadTwo.start();

        Thread threadThree = new Thread(()->{
            for (int i =0; i<10; i++){
                System.out.println("This is the thread that is running in the main but it is known as a lambda funtion" + i);
            }
        });
        threadThree.start();
    }
}
