package homework.chapter11;

public class ExtendThread {
    public static void main(String[] args) {
        NewerThread nt = new NewerThread();
        nt.start();

        try{
            for (int i = 0; i < 5; i++) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
