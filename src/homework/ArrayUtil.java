package homework;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        int size = numbers.length;
        //1.Տպել բոլոր էլեմենտները իրար կողք, բաժանված պռաբելով։
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //2.Տպել մասիվի առաջին էլեմենտը
        System.out.println("The first element in numbers is:" + numbers[0]);

        //3.Տպել մասիվի վերջին էլեմենտը
        System.out.println("The last element in numbers is: " + numbers[size - 1]);

        //4.Տպել մասիվի երկարությունը
        System.out.println("Numbers lenght is: " + size);

        //5.Տպել մասիվի ամենափոքր թիվը
        int min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Smallest is: " + min);

        //6.Տպել մասիվի մեջտեղի թիվը, ստուգել որ 2-ից մեծ լինի երկարությունը,
        //եթե փոքր կամ հավասար էղավ, տպեք որ can't print middle values.
        // եթե զույգ է մասիվի մեջի էլեմենտների թիվը, տպեք մեջտեղի երկու էլեմենտները,
        // եթե կենտ է մի հատը։
        if (size > 2) {
            if (size % 2 == 0){
                System.out.println("Array has even number of elements");
                System.out.println("Here is element number " + (size/2) + " : " + numbers[(size/2) - 1] );
                System.out.println("And here is element number " + ((size/2) + 1) + " : " + numbers[size/2]);
            }
            else{
                System.out.println("Array has odd number of elements");
                System.out.println("Here is the middle one: " + numbers[size/2]);
            }
        } else {
            System.out.println("can't print middle values");
        }

        //7. Հաշվել ու տպել մասիվում զույգերի քանակը։
        int numberOfEvens = 0;
        for (int i = 0; i < size; i++) {
            if(numbers[i] % 2 == 0){
                numberOfEvens ++;
            }
        }
        System.out.println("There are " + numberOfEvens + " even numbers in array");

        //8. Հաշվել ու տպել մասիվում կենտերի քանակը։
        int numberOfOdds = 0;
        for (int i = 0; i < size; i++) {
            if(numbers[i] % 2 != 0){
                numberOfOdds ++;
            }
        }
        System.out.println("There are " + numberOfOdds + " odd numbers in array");

        //9. Տպել մասիվում էլեմենտների գումարը։
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numbers[i];
        }
        System.out.println("The sum of all numbers in array is : " + sum);

        //10.Տպել մասիվում թվերի միջին թվաբանականը։
        System.out.println("Average of all numbers in array is: " + (double)sum/size);


    }
}
