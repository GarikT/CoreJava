package homework.chapter6;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
        double vol;

//        myBox1.width = 10;
//        myBox1.depth = 15;
//        myBox1.height = 20;
//
//        myBox2.width = 3;
//        myBox2.height = 6;
//        myBox2.depth = 9;
        myBox1.setDim(10, 20, 15);
        myBox2.setDim(3, 6, 9);

//        vol = myBox1.depth * myBox1.height * myBox1.width;
//        System.out.println("Volue is " + vol);
//
//        vol = myBox2.depth * myBox2.height * myBox2.width;
//        System.out.println("Volue is " + vol);
        System.out.println("Volume is: " + myBox1.volume());
        System.out.println("Volume is: " + myBox2.volume());
    }
}
