package classwork.chapter6;

public class BoxTest {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
//        myBox.width = 8.8;
//        System.out.println(myBox.width);
//        System.out.println(myBox.depth);
//        System.out.println(myBox.height);
//        System.out.println();
//
//        System.out.println(myBox2.width);
//        System.out.println(myBox2.depth);
//        System.out.println(myBox2.height);
        double vol;
        vol = myBox1.volume();
        System.out.println("Volume is " + vol);

        vol = myBox2.volume();
        System.out.println("Volume is " + vol);

        Box myBox3 = new Box(10, 20, 15);
        Box myBox4 = new Box(3, 6, 9);

        vol = myBox3.volume();
        System.out.println("Volume is " + vol);
        vol = myBox4.volume();
        System.out.println("Volume is " + vol);
    }
}
