package classwork.chapter11;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        MyFirstThread myFirstThread = new MyFirstThread();
        for (int i = 0; i <2; i++) {
            Thread myThread = new Thread(myFirstThread);
            myThread.start();
        }


        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
