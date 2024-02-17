package classwork.Chapter7;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String fullName = scanner.nextLine();
//        String[] fullNameArray = fullName.split(" ");
//        System.out.println(fullNameArray[0]);
//        System.out.println(fullNameArray[1]);
//        System.out.println("please enter a:");
//        int a = Integer.parseInt( scanner.nextLine() );
//        System.out.println("please enter b:");
//        int b = Integer.parseInt(scanner.nextLine());
//        System.out.println(a+b);

        System.out.println("Please enter number divided by commas");
        String numbersStr = scanner.nextLine();
        String[] numberStrArray = numbersStr.split(",");
        int[] number = new int[numberStrArray.length];
        int index = 0;
        for (String num: numberStrArray) {
            number[index++] = Integer.parseInt(num);
        }

    }
}
