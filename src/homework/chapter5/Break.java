package homework.chapter5;

public class Break {
    public static void main(String[] args) {
        boolean t = true;

        first:{
            second:{
                third:{
                    System.out.println("Before the break");
                    if(t){
                        break second;
                    }
                    System.out.println("This wont' execute");
                }
                System.out.println("this won't execute");
            }
            System.out.println("This is after second block");
        }
    }
}
