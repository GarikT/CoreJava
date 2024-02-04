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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size ; j++) {
                if(j < i){
                    s = s + "  ";
                }else{
                    s = s + "* ";
                }
            }
            System.out.println(s);
            s = "";
        }
        /*   Example 5
             *
            * *
           * * *
          * * * *
         * * * * *
          * * * *
           * * *
            * *
             *
         */
        //In this stage I'm sure you want to see something like this:
        System.out.println("\n==== Example 5 ====\n");
        System.out.println("    *");
        System.out.println("   * *");
        System.out.println("  * * *");
        System.out.println(" * * * *");
        System.out.println("* * * * *");
        System.out.println(" * * * *");
        System.out.println("  * * *");
        System.out.println("   * *");
        System.out.println("    *");
        //But I liked the challenge and wrote a little-bit of a advanced one. Just for fun.
        //Please refer to methods below:
        System.out.println("\n==== Example 5  My Version ====\n");
        for (int i = 1; i <= 5; i++) {
            System.out.println(getLine(5-i, i));
        }
        for (int i = 4; i >= 1 ; i--) {
            System.out.println(getLine(5-i, i));
        }


    }
    public static String addStars(int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            result = result + "* ";
        }
        return result;
    }
    public static String addSpaces(int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            result = result + " ";
        }
        return result;
    }
    public static String getLine(int spaces, int stars){
        String result = addSpaces(spaces);
        result = result + addStars(stars);
        return result;
    }
}
