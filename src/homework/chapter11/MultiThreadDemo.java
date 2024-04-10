package homework.chapter11;

public class MultiThreadDemo {
    public static void main(String[] args) {
        MyNewThread mnt1 = new MyNewThread("One");
        MyNewThread mnt2 = new MyNewThread("Two");
        MyNewThread mnt3 = new MyNewThread("Three");

        mnt1.t.start();
        mnt2.t.start();
        mnt3.t.start();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Thread One is alive: " + mnt1.t.isAlive());
        System.out.println("Thread Two is alive: " + mnt2.t.isAlive());
        System.out.println("Thread Three is alive: " + mnt3.t.isAlive());


        System.out.println("Main thread exiting");


    }
}
