package homework.Chapter12;

public class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Here are all Apple constants");
        Apple allapples[] = Apple.values();
        for (Apple apple : allapples) {
            System.out.println(apple);
        }
        System.out.println();
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains " + ap);
    }
}
