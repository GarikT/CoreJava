package homework.chapter9.p2;
import homework.chapter9.p1.Protection;
public class OtherPackage {
    OtherPackage(){
        Protection p = new Protection();
        System.out.println("other package constructor");
        //System.out.println("n = " + p.n);
        //System.out.println("n_pri = " + p.n_pri);
        //System.out.println("n_pro = " + p.n_pro);
        System.out.println("n_pub = " + p.n_pub);

    }
}
