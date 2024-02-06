package homework.chapter5;

public class While {
    public static void main(String[] args) {
        int n = 10;
        while(n > 0) {
            System.out.println("tick " + n);
            n--;
        }

        n = 10;
        do{
            System.out.println("tick " + n);
            //n--;
        }while(--n > 0);
    }
}
