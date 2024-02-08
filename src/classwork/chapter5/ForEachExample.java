package classwork.chapter5;

public class ForEachExample {
    public static void main(String[] args) {
        int[] array = {4, 5, 7, 8};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        for(int x: array){
            System.out.print(x);
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println(sum);

//        outerLoop:
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (i * j > 6) {
//                    break outerLoop; // Breaks out of the outer loop when i * j > 6
//                }
//                System.out.println(i + " * " + j + " = " + (i * j));
//            }
//        }

        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    continue outerLoop; // Skips the rest of the inner loop when i == j
                }
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }


    }
}
