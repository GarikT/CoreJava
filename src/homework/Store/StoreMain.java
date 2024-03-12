package homework.Store;

import homework.Store.enums.UserType;
import homework.Store.interfaces.AdminLogIn;
import homework.Store.interfaces.Start;
import homework.Store.interfaces.UserCommands;
import homework.Store.model.User;
import homework.Store.storage.OrderStorage;
import homework.Store.storage.ProductStorage;
import homework.Store.storage.UserStorage;

import java.util.Scanner;

public class StoreMain {
    public static OrderStorage orderStorage = new OrderStorage();
    public static ProductStorage productStorage = new ProductStorage();
    public static UserStorage userStorage = new UserStorage();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while(isRunning) {
            Start.printWelcome();
            String userInput = scanner.nextLine();
            switch (userInput){
                case Start.LOGIN:
                    //Ask user id and password
                    System.out.println("Please enter your id");
                    String idFromUser = scanner.nextLine();
                    System.out.println("Please enter your password");
                    String passwordFromUser = scanner.nextLine();
                    //Check if such a user exists
                    if(!userStorage.checkUser(idFromUser, passwordFromUser)){
                        //if no such user let them know
                        System.out.println("No such user");
                    }else if(userStorage.isAdmin(idFromUser)){
                        AdminLogIn.printAdminCommands();
                        //isRunning = false;
                    }else{
                        User user = userStorage.getUser(idFromUser, passwordFromUser);
                        UserCommands.printUserCommands(user);
                        //isRunning = false;
                    }
                    //if the user exists, based on user type show either user or admin commands
                    break;
                case Start.REGISTER:
                    // Gather all the necessary info and create a user
                    System.out.println("Please enter your id: ");
                    String id = scanner.nextLine();
                    System.out.println("Please enter your full name: ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter your email: ");
                    String email = scanner.nextLine();
                    System.out.println("Please enter your password");
                    String password = scanner.nextLine();
                    boolean adminOrUser = true;
                    UserType t = UserType.USER;
                    while(adminOrUser) {
                        System.out.println("Please enter U if you are a user");
                        System.out.println("And A if you are an admin: ");
                        String type = scanner.nextLine();
                        switch (type) {
                            case "U", "u":
                                t = UserType.USER;
                                adminOrUser = false;
                                break;
                            case "A", "a":
                                t = UserType.ADMIN;
                                adminOrUser = false;
                                break;
                            default:
                                System.out.println("Wrong input. please try again: ");
                        }
                    }
                    User u = new User(id, name, email, password, t);
                    userStorage.addUser(u);
                    // Based on what type of user this is, display their appropriate commands
                    if(t.equals(UserType.ADMIN)){
                        AdminLogIn.printAdminCommands();
                        //isRunning = false;
                    }else{
                        User user = userStorage.getUser(id, password);
                        UserCommands.printUserCommands(user);
                        //isRunning = false;
                    }
                    break;
                default:
                    System.out.println("Wrong command. Please try again.");
            }
        }
    }

}
