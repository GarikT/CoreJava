package homework.chapter7;

public class Recursion2 {
    public static void main(String[] args) {
        RecTest ob = new RecTest(20);
        for (int i = 0; i < 10; i++) {
            ob.values[i] = i;
        }
        ob.printArray(10);
    }
}
