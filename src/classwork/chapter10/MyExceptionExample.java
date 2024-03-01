package classwork.chapter10;

public class MyExceptionExample {
    public static void main(String[] args) {
//        int a = 10;
//        int c = a * 6;
//        try {
//            System.out.println(a / 0);
//        }catch(ArithmeticException e){
//            System.out.println("Can't divide a number by 0");
//        }
        String name = "Poxos99";
        try {
            String s = StringUtil.checkString(name);
            System.out.println(s);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
