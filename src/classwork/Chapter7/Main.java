package classwork.Chapter7;

public class Main {
    public static void main(String[] args) {
        String name = new String("Poxos");
        String name1 = "Poxos";
        String name2 = "Poxos";

        System.out.println("name == name1 :" + (name == name1) );
        System.out.println("name.equals(name1): " + name.equals(name1));
        System.out.println("name1 == name2 :" + (name1 == name2));
        System.out.println("name1.equals(name2): " + name1.equals(name2));
    }
}
