package classwork.onlineStore;

import classwork.onlineStore.command.Commands;
import classwork.onlineStore.model.Order;
import classwork.onlineStore.model.Product;
import classwork.onlineStore.model.User;
import classwork.onlineStore.model.enums.OrderStatus;
import classwork.onlineStore.model.enums.PaymentMethod;
import classwork.onlineStore.model.enums.ProductType;
import classwork.onlineStore.storage.OrderStorage;
import classwork.onlineStore.storage.ProductStorage;
import classwork.onlineStore.storage.UserStorage;
import classwork.onlineStore.util.IdGenerator;
import classwork.onlineStore.util.StorageSerializeUtil;
import homework.Store.enums.UserType;

import java.util.Date;
import java.util.Scanner;

public class OnlineStoreMain implements Commands {

    private final static Scanner SCANNER = new Scanner(System.in);
    private final static OrderStorage ORDER_STORAGE = StorageSerializeUtil.deserializeOrderStorage();
    private final static ProductStorage PRODUCT_STORAGE = StorageSerializeUtil.deserializeProductStorage();
    private final static UserStorage USER_STORAGE = StorageSerializeUtil.deserializeUserStorage();
    private static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;
        while(isRun){
            Commands.printMainCommands();
            String command = SCANNER.nextLine();
            switch (command){
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Unknown Command!");
            }
        }
    }

    private static void register() {
        System.out.println("Please input name, email, password,userType(ADMIN, USER)");
        String userDataStr = SCANNER.nextLine();
        String[] userDataArr =  userDataStr.split(",");
        User user = USER_STORAGE.getByEmail(userDataArr[1]);
        if(user != null){
            System.out.println("User already exists!");
            return;
        }
        try{
            user = new User(IdGenerator.genrageId(), userDataArr[0], userDataArr[1], userDataArr[2], UserType.valueOf(userDataArr[3].toUpperCase()));
            USER_STORAGE.add(user);
            System.out.println("User registered!");
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid data or user type!");
        }
    }

    private static void login() {
        System.out.println("Please input email, password");
        String loginDataStr = SCANNER.nextLine();
        String[] loginDataArr = loginDataStr.split(",");
        User user = USER_STORAGE.getByEmail(loginDataArr[0]);
        if(user == null || !user.getPassword().equals(loginDataArr[1])){
            System.out.println("email or password is incorrect!");
            return;
        }
        currentUser = user;
        if(user.getUserType() == UserType.ADMIN){
            adminCommands();
        }else if(user.getUserType() == UserType.USER){
            userCommands();
        }
    }
    private static void adminCommands() {
        boolean isRun = true;
        while(isRun){
            Commands.printAdminCommands();
            String command = SCANNER.nextLine();
            switch (command){
                case LOGOUT:
                    isRun = false;
                    currentUser = null;
                    return;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case REMOVE_PRODUCT_BY_ID:
                    removeProductById();
                    break;
                case PRINT_PRODUCTS:
                    PRODUCT_STORAGE.print();
                    break;
                case PRINT_USERS:
                    USER_STORAGE.printByType(UserType.USER);
                    break;
                case PRINT_ORDERS:
                    ORDER_STORAGE.print();
                    break;
                case CHANGE_ORDER_STATUS_BY_ID:
                    changeOrderStatusById();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }

    }

    private static void userCommands() {
        boolean isRun = true;
        while(isRun) {
            Commands.printUserCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    currentUser = null;
                    return;
                case PRINT_ALL_PRODUCTS:
                    PRODUCT_STORAGE.print();
                    break;
                case BUY_PRODUCT:
                    buyProduct();
                    break;
                case PRINT_MY_ORDERS:
                    ORDER_STORAGE.printByUser(currentUser);
                    break;
                case CANCEL_ORDER_BY_ID:
                    cancelOrderById();
                    break;
                default:
                    System.out.println("Unknown Command!");
            }
        }
    }

    private static void buyProduct() {
        PRODUCT_STORAGE.print();
        System.out.println("Please input product id, qty,Payment Method(CARD, CASH, PAYPAL)");
        String orderDataStr = SCANNER.nextLine();
        String[] orderDataArr = orderDataStr.split(",");
        Product product = PRODUCT_STORAGE.getById(orderDataArr[0]);
        PaymentMethod paymentMethod = PaymentMethod.valueOf(orderDataArr[2]);
        if(product == null){
            System.out.println("Wrong product id");
            return;
        }
        int qty = Integer.parseInt(orderDataArr[1]);
        if(product.getStockQty()< qty){
            System.out.println("Wrong qty");
            return;
        }
        double price = qty * product.getPrice();
        System.out.println("You want to buy " + product.getName()
                + " qty: " + qty + " price: " + price +
                " PaymentMethod: " + paymentMethod +
                "\nAre you sure? (Yes/No)" );
        String answer = SCANNER.nextLine();
        if(!answer.equalsIgnoreCase("yes")) {
            System.out.println("Oder cancelled");
            return;
        }
        Order order = new Order(IdGenerator.genrageId(), currentUser,
                product, qty, new Date(), price, OrderStatus.NEW, paymentMethod);
        ORDER_STORAGE.add(order);
    }

    private static void cancelOrderById() {
        ORDER_STORAGE.printByUser(currentUser);
        System.out.println("Please input order id");
        String orderId = SCANNER.nextLine();
        Order order = ORDER_STORAGE.getById(orderId);
        if(order == null || !order.getUser().equals(currentUser)){
            System.out.println("Wrong order id");
            return;
        }
        if(order.getOrderStatus() != OrderStatus.NEW){
            System.out.println("Order cannot be cancelled");
            return;
        }
        order.setOrderStatus(OrderStatus.CANCELED);
        System.out.println("Order cancelled");
        StorageSerializeUtil.serialiseOrderStorage(ORDER_STORAGE);
    }

    private static void changeOrderStatusById() {
        ORDER_STORAGE.print();
        System.out.println("Please input order id, new status(NEW, DELIVERED, CANCELED)");
        String orderDateStr = SCANNER.nextLine();
        String[] orderDataArr = orderDateStr.split(",");
        Order order = ORDER_STORAGE.getById(orderDataArr[0]);
        if(order == null){
            System.out.println("Order does not exist");
            return;
        }
        OrderStatus newStatus = OrderStatus.valueOf(orderDataArr[1]);
        if(order.getOrderStatus().equals(OrderStatus.NEW) && newStatus.equals(OrderStatus.DELIVERED) ){
            if(order.getProduct().getStockQty() < order.getQty()){
                System.out.println("You do not have enough product qty");
                return;
            }
            order.getProduct().setStockQty(order.getProduct().getStockQty() - order.getQty());
            order.setOrderStatus(newStatus);
            System.out.println("Order status has changed!");
            StorageSerializeUtil.serialiseOrderStorage(ORDER_STORAGE);
        }


    }

    private static void removeProductById() {
        PRODUCT_STORAGE.print();
        System.out.println("Please input product id");
        String productId = SCANNER.nextLine();
        Product product = PRODUCT_STORAGE.getById(productId);
        if(product == null){
            System.out.println("Wrong product id");
            return;
        }
        product.setRemoved(true);
        StorageSerializeUtil.serialiseProductStorage(PRODUCT_STORAGE);
    }

    private static void addProduct() {
        System.out.println("Please input name, description, stockQty, price, productType(ELECTRONICS, CLOTHING, BOOKS");
        String productDateStr = SCANNER.nextLine();
        String[] productDataArr = productDateStr.split(",");
        try {
            Product product = new Product();
            product.setId(IdGenerator.genrageId());
            product.setName(productDataArr[0]);
            product.setDescription(productDataArr[1]);
            product.setStockQty(Integer.parseInt(productDataArr[2]));
            product.setPrice(Double.parseDouble(productDataArr[3]));
            product.setProductType(ProductType.valueOf(productDataArr[4]));
            PRODUCT_STORAGE.add(product);
            System.out.println("Product added!");
        }catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid date: " + e.getMessage());
        }
    }




}
