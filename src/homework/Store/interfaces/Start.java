package homework.Store.interfaces;

public interface Start {
    String LOGIN = "0";
    String REGISTER = "1";
    static void printWelcome(){
        System.out.println("Welcome to our store!");
        System.out.println("Please enter " + LOGIN + " to log in");
        System.out.println("Or " + REGISTER + " to register");
    }
}
