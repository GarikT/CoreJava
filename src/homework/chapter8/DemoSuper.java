package homework.chapter8;

public class DemoSuper {
    public static void main(String[] args) {
        BoxWeight mb1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight mb2 = new BoxWeight(2, 3, 4, 0.076);
        BoxWeight mb3 = new BoxWeight();
        BoxWeight mycube = new BoxWeight(3, 2);
        BoxWeight myclone = new BoxWeight(mb1);
        double vol;
        vol = mb1.volume();
        System.out.println("Volume of mb1 is " + vol);
        System.out.println("Weight of mb1 is " + mb1.weight);
        System.out.println();

        vol = mb2.volume();
        System.out.println("Voluem of mb2 is " + vol);
        System.out.println("Weight of mb2 is " + mb2.weight);
        System.out.println();

        vol = mb3.volume();
        System.out.println("Voluem of mb3 is " + vol);
        System.out.println("Weight of mb3 is " + mb3.weight);
        System.out.println();

        vol = myclone.volume();
        System.out.println("Voluem of myclone is " + vol);
        System.out.println("Weight of myclone is " + myclone.weight);
        System.out.println();

        vol = mycube.volume();
        System.out.println("Voluem of mycube is " + vol);
        System.out.println("Weight of mycube is " + mycube.weight);
        System.out.println();
    }
}
