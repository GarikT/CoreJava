package homework.Store.interfaces;

import homework.Store.StoreMain;
import homework.Store.enums.OrderStatus;
import homework.Store.enums.ProductType;
import homework.Store.model.Order;
import homework.Store.model.Product;

public interface AdminLogIn {
    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";

    static void printAdminCommands(){
        boolean isRuningAdmin = true;
        while(isRuningAdmin) {
            System.out.println("Please enter " + LOGOUT + " to log out");
            System.out.println("Please enter " + ADD_PRODUCT + " to add product");
            System.out.println("Please enter " + REMOVE_PRODUCT_BY_ID + " to remove product by id");
            System.out.println("Please enter " + PRINT_PRODUCTS + " to print products");
            System.out.println("Please enter " + PRINT_USERS + " to print users (excluding admins)");
            System.out.println("Please enter " + PRINT_ORDERS + " to print orders");
            System.out.println("Please enter " + CHANGE_ORDER_STATUS + " to change order status");
            String input = StoreMain.scanner.nextLine();
            switch (input){
                case LOGOUT:
                    isRuningAdmin = false;
                    break;
                case ADD_PRODUCT:
                    StoreMain.productStorage.addProduct(getProduct());
                    break;
                case REMOVE_PRODUCT_BY_ID:
                    System.out.println("Please enter product id");
                    String prodId = StoreMain.scanner.nextLine();
                    StoreMain.productStorage.removeProductById(prodId);
                    break;
                case PRINT_PRODUCTS:
                    StoreMain.productStorage.printAllProducts();
                    break;
                case PRINT_USERS:
                    StoreMain.userStorage.printRegularUsers();
                    break;
                case PRINT_ORDERS:
                    StoreMain.orderStorage.printOrders();
                    break;
                case CHANGE_ORDER_STATUS:
                    System.out.println("Please enter the ID of the order you want to update status");
                    String id = StoreMain.scanner.nextLine();
                    Order o = StoreMain.orderStorage.getOrderById(id);
                    if(o == null){
                        System.out.println("No such order");
                        break;
                    }
                    boolean statusRunning = true;
                    while(statusRunning) {
                        System.out.println("Please enter new status: ");
                        System.out.println("Enter C for CANCELLED, N for NEW and D for DELIVERED");
                        OrderStatus ot = OrderStatus.NEW;
                        String status = StoreMain.scanner.nextLine();
                        switch (status) {
                            case "n", "N":
                                ot = OrderStatus.NEW;
                                statusRunning = false;
                                break;
                            case "c", "C":
                                ot = OrderStatus.CANCELED;
                                statusRunning = false;
                                break;
                            case "d", "D":
                                ot = OrderStatus.DELIVERED;
                                statusRunning = false;
                                break;
                            default:
                                System.out.println("Wrong command, please try again: ");
                        }
                        StoreMain.orderStorage.changeOrderStatus(o, ot);
                    }
                    break;
                default:
                    System.out.println("Invalid command, try again!");
            }
        }

    }

    static Product getProduct() {
        System.out.println("Enter product ID: ");
        String id = StoreMain.scanner.nextLine();
        System.out.println("Enter product name: ");
        String name = StoreMain.scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = StoreMain.scanner.nextLine();
        System.out.println("Enter product price: ");
        Double price = Double.parseDouble(StoreMain.scanner.nextLine());
        System.out.println("Enter stock quantity: ");
        int qty = Integer.parseInt(StoreMain.scanner.nextLine());
        ProductType pt = ProductType.ELECTRONICS;
        boolean ptype = true;
        while(ptype) {
            System.out.println("Enter product type");
            System.out.println("Please enter E for electronics");
            System.out.println("Please enter C for clothing");
            System.out.println("Please enter B for books");
            String type = StoreMain.scanner.nextLine();
            switch (type){
                case "e", "E":
                    pt = ProductType.ELECTRONICS;
                    ptype = false;
                    break;
                case "c", "C":
                    pt = ProductType.CLOTHING;
                    ptype = false;
                    break;
                case "b", "B":
                    pt = ProductType.BOOKS;
                    ptype = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again!");
            }
        }
        Product product = new Product(id, name, description, price, qty, pt);
        return product;
    }
}
