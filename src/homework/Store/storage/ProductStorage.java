package homework.Store.storage;

import homework.Store.Exceptions.OutOfStockException;
import homework.Store.StoreMain;
import homework.Store.enums.OrderStatus;
import homework.Store.enums.PaymentMethod;
import homework.Store.model.Order;
import homework.Store.model.Product;
import homework.Store.model.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage {
    private Set<Product> products = new HashSet<>();
    public ProductStorage() {
    }

    public void AddProduct(Product p){
        products.add(p);
        System.out.println("Product successfully added!");
    }

    public void removeProductById(String id){
        for (Product product : products) {
            if(product.getId().equals(id)){
                products.remove(product);
                System.out.println("Product successfully removed");
            }
        }
    }
    public void printAllProducts(){
        if(products.size() == 0){
            System.out.println("No products at this time. Check back later");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private Product getProductById(String productID){
        Product result = null;
        for (Product product : products) {
            if(product.getId().equals(productID)){
                result = product;
                break;
            }
        }
        return result;
    }

    public void buyProduct(User user) throws OutOfStockException {
        System.out.println("Please enter order ID");
        String orderId = StoreMain.scanner.nextLine();
        System.out.println("Please enter product ID");
        String productID = StoreMain.scanner.nextLine();
        Product product = getProductById(productID);
        if(product == null){
            System.out.println("No such product");
            return;
        }
        Date date = new Date();
        double price = product.getPrice();
        System.out.println("Please enter quantity you'd like to purchase: ");
        int quantity = Integer.parseInt(StoreMain.scanner.nextLine());
        if(quantity > product.getStockQty()){
            throw new OutOfStockException();
        }
        OrderStatus orderStatus = OrderStatus.NEW;
        PaymentMethod paymentMethod = PaymentMethod.CASH;
        boolean getPayment = true;
        while(getPayment) {
            System.out.println("How are you going to pay?");
            System.out.println("Please enter C for card, K for cash and P for PayPal");
            String pm = StoreMain.scanner.nextLine();
            switch (pm) {
                case "c", "C":
                    paymentMethod = PaymentMethod.CARD;
                    getPayment = false;
                    break;
                case "k", "K":
                    paymentMethod = PaymentMethod.CASH;
                    getPayment = false;
                    break;
                case "p", "P":
                    paymentMethod = PaymentMethod.PAYPAL;
                    getPayment = false;
                    break;
                default:
                    System.out.println("Wrong entry, try again!");
            }
        }
        System.out.println("Your order is for " + quantity + " " + product.getName() + "s and your total is "+
                (quantity * price) );
        System.out.println("Please type yes to confirm this order, or no to opt out");
        String confirmation = StoreMain.scanner.nextLine();
        if(confirmation.toUpperCase().equals("YES")){
            Order order = new Order(orderId, user, product, date, price, orderStatus, quantity, paymentMethod);
            StoreMain.orderStorage.addOrder(order);
            System.out.println("Order successfully placed!");
        }
    }

//    private Product[] products = new Product[10];
//    private int size;
//
//    public ProductStorage() {
//        size = 0;
//    }
//
//    public void addProduct(Product p){
//        if(size >= products.length){
//            extend();
//        }
//        products[size] = p;
//        size++;
//        System.out.println("Product successfully added!");
//    }
//
//    private void extend(){
//        if(size >= products.length){
//            Product[] temp = new Product[products.length + 10];
//            System.arraycopy(products, 0, temp, 0, products.length);
//            products = temp;
//        }
//    }
//
//    public void removeProductById(String id){
//        int index = getIndexById(id);
//        removeByIndex(index);
//    }
//
//    public void printAllProducts(){
//        if(size == 0){
//            System.out.println("No products at this time. Check back later");
//        }
//        for (int i = 0; i < size; i++) {
//            System.out.println(products[i]);
//        }
//    }
//
//    //private methods
//    private int getIndexById(String id){
//        int result = -1;
//        for (int i = 0; i < size; i++) {
//            if(products[i].getId().equals(id)){
//                result = i;
//                break;
//            }
//        }
//        return result;
//    }
//
//    private void removeByIndex(int i){
//        if(i<0 && i>size){
//            System.out.println("No such product");
//        }else{
//            for (int j = i; j < size; j++) {
//                products[j] = products[j+1];
//            }
//            size--;
//            System.out.println("Product successfully removed");
//        }
//    }
//
//
//    public void buyProduct(User user) throws OutOfStockException {
//        System.out.println("Please enter order ID");
//        String orderId = StoreMain.scanner.nextLine();
//        System.out.println("Please enter product ID");
//        String productID = StoreMain.scanner.nextLine();
//        Product product = StoreMain.productStorage.getProductById(productID);
//        if(product == null){
//            System.out.println("No such product");
//            return;
//        }
//        Date date = new Date();
//        double price = product.getPrice();
//        System.out.println("Please enter quantity you'd like to purchase: ");
//        int quantity = Integer.parseInt(StoreMain.scanner.nextLine());
//        if(quantity > product.getStockQty()){
//            throw new OutOfStockException();
//        }
//        OrderStatus orderStatus = OrderStatus.NEW;
//        PaymentMethod paymentMethod = PaymentMethod.CASH;
//        boolean getPayment = true;
//        while(getPayment) {
//            System.out.println("How are you going to pay?");
//            System.out.println("Please enter C for card, K for cash and P for PayPal");
//            String pm = StoreMain.scanner.nextLine();
//            switch (pm) {
//                case "c", "C":
//                    paymentMethod = PaymentMethod.CARD;
//                    getPayment = false;
//                    break;
//                case "k", "K":
//                    paymentMethod = PaymentMethod.CASH;
//                    getPayment = false;
//                    break;
//                case "p", "P":
//                    paymentMethod = PaymentMethod.PAYPAL;
//                    getPayment = false;
//                    break;
//                default:
//                    System.out.println("Wrong entry, try again!");
//            }
//        }
//        System.out.println("Your order is for " + quantity + " " + product.getName() + "s and your total is "+
//                (quantity * price) );
//        System.out.println("Please type yes to confirm this order, or no to opt out");
//        String confirmation = StoreMain.scanner.nextLine();
//        if(confirmation.toUpperCase().equals("YES")){
//            Order order = new Order(orderId, user, product, date, price, orderStatus, quantity, paymentMethod);
//            StoreMain.orderStorage.addOrder(order);
//            System.out.println("Order successfully placed!");
//        }
//    }
//
//    private Product getProductById(String productID) {
//        Product result = null;
//        for (int i = 0; i < size; i++) {
//            if(products[i].getId().equals(productID)) {
//                result = products[i];
//                break;
//            }
//        }
//        return result;
//    }
}
