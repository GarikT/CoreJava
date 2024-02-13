package homework1.DynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynArr = new DynamicArray();
        dynArr.add(1);
        dynArr.add(2);
        dynArr.add(3);
        dynArr.add(4);
        dynArr.add(5);
        dynArr.add(6);
        dynArr.add(7);
        dynArr.add(8);
        dynArr.add(9);
        dynArr.add(10);
        dynArr.add(11);
        dynArr.print();

        dynArr.deleteByIndex(16);
        System.out.println();
        dynArr.print();

        System.out.println();
        dynArr.set(17, 77);
        dynArr.print();

        System.out.println();
        dynArr.add(1, -27);
        dynArr.print();
        System.out.println();

        System.out.println(dynArr.exists(-2));
        System.out.println();

        System.out.println(dynArr.getIndexByValue(-11));
    }
}
