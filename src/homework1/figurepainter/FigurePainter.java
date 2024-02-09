package homework1.figurepainter;

public class FigurePainter {

    void figureOne(int n){
        /*   Example 1
         *
         * *
         * * *
         * * * *
         * * * * *
         */
        //System.out.println("==== Example 1 ====\n");
        if(n < 1){
            System.out.println("Invalid value");
            return;
        }
        int size = n;
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + "* ";
            System.out.println(s);
        }
    }
    void figureTwo(int n){
        /*   Example 2
         * * * * *
         * * * *
         * * *
         * *
         *
         */
        if(n < 1){
            System.out.println("Invalid value");
            return;
        }
        int size = n;
        //System.out.println("\n==== Example 2 ====\n");
        String s = "";
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                s = s + "* ";
            }
            System.out.println(s);
            s = "";
        }
    }
    void figureThree(int n){
        /*   Example 3
         *
         * *
         * * *
         * * * *
         * * * * *
         */
        //System.out.println("\n==== Example 3 ====\n");
        if(n < 1){
            System.out.println("Invalid value");
            return;
        }
        String s = "";
        int size = n;
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
    }
    void figureFour(int n){
        /*   Example 4
         * * * * *
         * * * *
         * * *
         * *
         *
         */
        //System.out.println("\n==== Example 4 ====\n");
        if(n < 1){
            System.out.println("Invalid value");
            return;
        }
        String s = "";
        int size = n;
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
    }
    void figureFive(int n){
        if(n < 1){
            System.out.println("Invalid value");
            return;
        }
        String s = "";
        int size = n;
        for (int i = 1; i <= size; i++) {
            for (int j = size; j > 0; j--) {
                if (i < j) {
                    if (j != size) {
                        s = s + " ";
                    }
                } else {
                    if (j == size) {
                        s = "*";
                    } else {
                        s = s + " *";
                    }
                }
            }
            System.out.println(s);
            s = "";
        }
        size = n-1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size ; j++) {
                if(j == 0){
                    s = s + " ";
                }
                if(j < i){
                    s = s + " ";
                }else{

                    s = s + "* ";
                }
            }
            System.out.println(s);
            s = "";
        }
    }
//    public static void main(String[] args) {
//
//
//
//        ≈
//
//
//    }
//    public static String addStars(int count){
//        String result = "";
//        for (int i = 0; i < count; i++) {
//            result = result + "* ";
//        }
//        return result;
//    }
//    public static String addSpaces(int count){
//        String result = "";
//        for (int i = 0; i < count; i++) {
//            result = result + " ";
//        }
//        return result;
//    }
//    public static String getLine(int spaces, int stars){
//        String result = addSpaces(spaces);
//        result = result + addStars(stars);
//        return result;
//    }
}
