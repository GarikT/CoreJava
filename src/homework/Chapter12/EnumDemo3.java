package homework.Chapter12;

public class EnumDemo3 {
    public static void main(String[] args) {
        AppleWithPrice awp;
        System.out.println("Winesap costs " + AppleWithPrice.Winesap.getPrice() +
                " cents\n");
        System.out.println("All apple prices: ");
        for (AppleWithPrice a : AppleWithPrice.values()) {
            System.out.println(a + " costs " +
                    a.getPrice() + " cents");
        }
    }
}
