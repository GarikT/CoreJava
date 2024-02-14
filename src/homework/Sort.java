package homework;

public class Sort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2, 26, -3, 48, 9};
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= array.length - 1; j++) {
                if(array[j-1] > array[j]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
