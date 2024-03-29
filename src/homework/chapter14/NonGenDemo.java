package homework.chapter14;

public class NonGenDemo {
    public static void main(String[] args) {
        NonGen iob;
        iob = new NonGen(88);
        iob.showType();

        int v = (Integer) iob.getob();
        System.out.println("value: " + v);

        NonGen strOb = new NonGen("Non-Generics Test");
        strOb.showType();
        String str = (String)strOb.getob();
        System.out.println("Value: " + str);

        iob = strOb;
        v = (Integer) iob.getob();
    }
}
