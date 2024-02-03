package homework1;

public class FigurePainter {
    public static void main(String[] args) {

        /*   Example 1
        *
        * *
        * * *
        * * * *
        * * * * *
        */
        System.out.println("==== Example 1 ====\n");
        int size = 5;
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + "* ";
            System.out.println(s);
        }


        /*   Example 2
         * * * * *
         * * * *
         * * *
         * *
         *
         */
        System.out.println("\n==== Example 2 ====\n");
        s = "";
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                s = s + "* ";
            }
            System.out.println(s);
            s = "";
        }

        /*   Example 3
                 *
               * *
             * * *
           * * * *
         * * * * *
         */
        System.out.println("\n==== Example 3 ====\n");
        s = "";
        for (int i = 1; i <= size; i++) {
            for (int j = size; j > 0 ; j--) {
                if(i < j){
                    if(j == size){
                        s = " ";
                    }else {
                        s = s + "  ";
                    }
                }else{
                    if(j == size){
                        s = "*";
                    }else {
                        s = s + " *";
                    }
                }
            }
            System.out.println(s);
            s = "";
        }


        /*   Example 4
        * * * * *
          * * * *
            * * *
              * *
                *
         */
        System.out.println("\n==== Example 4 ====\n");
        s = "";
        for (int i = 1; i <= size; i++) {
            for (int j = size; j > 0 ; j--) {
                if(i > j){
                    s = s + "  ";
                }else{
                    if(j == size){
                        s = "*";
                    }else {
                        s = s + " *";
                    }
                }
            }
            System.out.println(s);
            s = "";
        }


    }
}
