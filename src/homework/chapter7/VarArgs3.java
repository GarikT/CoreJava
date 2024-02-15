package homework.chapter7;

public class VarArgs3 {
    static void vaTest(int ... v){
        System.out.println("vaTest(int...): " +
                "Number of args: " + v.length +
                " Contentes: ");
        for (int i : v) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    static void vaTest(boolean ... v){
        System.out.println("vaTest(boolean ..." +
                "Number of args: " + v.length +
                " Contentes: ");
        for(boolean x : v)
            System.out.println(x + " ");
        System.out.println();
    }
    static void vaTest(String msg, int ... v) {
        System.out.println("vaTest(String, int ...): " +
                msg + v.length + " Contentes: ");
        for (int i : v) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        vaTest(1, 2, 3);
        vaTest("Testing: ", 10, 20);
        vaTest(true, false, false);
    }
}
