package classwork.chapter14;

public class StorageTest {
    public static void main(String[] args) {
        Storage<String> stringStorage = new Storage<>();
        stringStorage.add("Poxos");
        stringStorage.add("Petros");
        stringStorage.print();

        Storage<Integer> intStorage = new Storage<>();
        intStorage.add(10);
        intStorage.add(20);
        intStorage.print();
    }
}
