package homework.Store.interfaces;

import homework.Store.StoreMain;
import homework.Store.model.User;


public interface UserCommands {
    String LOGOUT = "0";
    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    static void printUserCommands(User user) {
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("Please enter " + LOGOUT + " to log out");
            System.out.println("Please enter " + PRINT_ALL_PRODUCTS + " to print all products");
            System.out.println("Please enter " + BUY_PRODUCT + " to buy a product");
            System.out.println("Please enter " + PRINT_MY_ORDERS + " to print your orders");
            System.out.println("Please enter " + CANCEL_ORDER_BY_ID + " to cancel order by id");
            String input = StoreMain.scanner.nextLine();
            switch (input){
                case LOGOUT:
                    isRunning = false;
                    break;
                case PRINT_ALL_PRODUCTS:
                    StoreMain.productStorage.printAllProducts();
                    break;
                case BUY_PRODUCT:
                    StoreMain.productStorage.buyProduct(user);
                    break;
                case PRINT_MY_ORDERS:
                    StoreMain.orderStorage.printMyOrders(user);
                    break;
                case CANCEL_ORDER_BY_ID:
                    System.out.println("Please enter order ID");
                    String id = StoreMain.scanner.nextLine();
                    StoreMain.orderStorage.cancelOrderById(id);
                    break;
                default:
                    System.out.println("Wrong command, please try again!");
            }
        }
    }
}
