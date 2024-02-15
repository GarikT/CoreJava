package homework.chapter7;

public class VarArgs {
    static void vaTest(int ... v){
        System.out.println("Number of args: " + v.length +
                " Contents: ");
        for (int i : v) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest(10);
        vaTest(1, 2, 3);
        vaTest();
    }
}
