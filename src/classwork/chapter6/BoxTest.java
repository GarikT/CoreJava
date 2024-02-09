package classwork.chapter6;

public class BoxTest {
    public static void main(String[] args) {
        Box myBox = new Box();
        Box myBox2 = new Box();
        myBox.width = 8.8;
        System.out.println(myBox.width);
        System.out.println(myBox.depth);
        System.out.println(myBox.height);
        System.out.println();

        System.out.println(myBox2.width);
        System.out.println(myBox2.depth);
        System.out.println(myBox2.height);
    }
}
