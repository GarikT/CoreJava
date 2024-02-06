package homework.Chapter4;

public class IncDec {
    public static void main(String[] args) {

        int x = 42;
        int y = x++;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int a = 1;
        int b = 2;
        int c;
        int d;
        c = ++b;
        d = a++;
        c++;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
