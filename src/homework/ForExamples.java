package homework;

public class ForExamples {
    public static void main(String[] args) {
        //1. Տպել 1-ից 1000 թվերը իրար կողք, արանքում դնելով - սինվոլը։ Այնպես գրեք, որ վերջում - չլինի։
        System.out.println("====== Problem 1 =======");
        for (int i = 1; i < 1000; i++) {
            System.out.print(i + "-");
        }
        System.out.println("1000");

        //2. Տպել 1-ից 100 թվերի մեջ ընկած զույգերը օգտագործելով % գործողությունը։
        System.out.println("\n\n====== Problem 2 =======");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

        //3. Հայտարարել թվերի մասիվ՝ int[] array = {2,5,8,4,9,3,7}, ֆոր- օգտագործելով գտնել մասիվի ամենամեծ թիվը ու տպել։
        System.out.println("\n\n====== Problem 3 =======");
        int array[] = {2, 5, 8, 4, 9, 3, 7};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.println("The biggest number in array is: " + max);

    }


}
