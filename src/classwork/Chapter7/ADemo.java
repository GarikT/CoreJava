package classwork.Chapter7;

import classwork.Chapter7.A;

public class ADemo {
    public static void main(String[] args) {
        A a = new A();
        a.x = 10;

        A a1 = new A();
        a1.x = 20;

        System.out.println(a.x);
        System.out.println(a1.x);

        A.y = 55;
        System.out.println(A.y);
        System.out.println("Object call: " + a.y);

        a.y = 40;
        System.out.println(A.y);

    }
}
