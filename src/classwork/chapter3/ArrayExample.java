package classwork.chapter3;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[5];
//        numbers[0] = 77;
//        numbers[1] = 88;
//        numbers[2] = 99;
//        numbers[3] = 66;
//        numbers[4] = 55;
        for (int i = 0; i < 5; i++) {
            numbers[i] = i + 1;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }
    }
}
