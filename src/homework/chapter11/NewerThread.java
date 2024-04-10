package homework.chapter11;

public class NewerThread extends Thread{
    NewerThread(){
        super("Demo Thread");
        System.out.println("Child thread: " + this);
    }

    public void run(){
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("Child interrupted. ");
        }
        System.out.println("Exiting child thread.");
    }

}
