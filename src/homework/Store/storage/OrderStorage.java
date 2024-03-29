package homework.Store.storage;

import homework.Store.Exceptions.OutOfStockException;
import homework.Store.enums.OrderStatus;
import homework.Store.model.Order;
import homework.Store.model.Product;
import homework.Store.model.User;

import java.util.LinkedList;
import java.util.List;

public class OrderStorage {
    private List<Order> orders = new LinkedList<>();

    public OrderStorage() {
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printOrders() {
        if (orders.size() <= 0) {
            System.out.println("No orders at this time!");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void printMyOrders(User user){
        for (Order order : orders) {
            if(order.getUser().equals(user)){
                System.out.println(order);
            }
        }
    }

    public void cancelOrderById(String id){
        for (Order order : orders) {
            if(order.getId().equals(id)){
                orders.remove(order);
            }
        }
    }

    public Order getOrderById(String id){
        Order result = null;
        for (Order order : orders) {
            if(order.getId().equals(id))
                result = order;
        }
        return result;
    }


    //    private Order[] orders = new Order[10];
//    private int size;
//
//
//
//    public OrderStorage() {
//    }
//
//    //Պետք է ունենա հետևյալ մեթոդները
//
//    public void addOrder(Order order){
//        if(size >= orders.length){
//            extend();
//        }
//        orders[size] = order;
//        size++;
//    }
//
//    private void extend(){
//        if(size >= orders.length){
//            Order[] temp = new Order[orders.length + 10];
//            System.arraycopy(orders, 0, temp, 0, orders.length);
//            orders = temp;
//        }
//    }
//
//    public void printOrders(){
//        if(size <= 0){
//            System.out.println("No orders at this time!");
//        }
//        for (int i = 0; i < size; i++) {
//            System.out.println(orders[i]);
//        }
//    }
//
//
    public void changeOrderStatus(Order order, OrderStatus status) throws OutOfStockException {
        if (status.equals(OrderStatus.DELIVERED)) {
            int quantity = order.getQty();
            Product p = order.getProduct();
            if (p.getStockQty() > quantity) {
                p.setStockQty(p.getStockQty() - quantity);
                order.setOrderStatus(status);
            } else {
                throw new OutOfStockException("Not enough inventory");
            }
        } else if (status.equals(OrderStatus.CANCELED)) {
            order.setOrderStatus(status);
            cancelOrderById(order.getId());
        }
    }
//
//
//    //Տպեն տվյալ յուզեռի բոլոր օրդերները
//    public void printMyOrders(User user){
//        for (int i = 0; i < size; i++) {
//            if(orders[i].getUser().equals(user)){
//                System.out.println(orders[i]);
//            }
//        }
//    }
//
//    public void cancelOrderById(String id){
//        removeByIndex(getIndexById(id));
//    }
//
//    //Private methods
//    private int getIndexById(String id){
//        int result = -1;
//        for (int i = 0; i < size; i++) {
//            if(orders[i].getId().equals(id)){
//                result = i;
//                break;
//            }
//        }
//        return result;
//    }
//
//    private void removeByIndex(int i){
//        if(i<0 && i>size){
//            System.out.println("No such order");
//        }else{
//            for (int j = i; j < size; j++) {
//                orders[j] = orders[j+1];
//            }
//            size--;
//            System.out.println("Order successfully cancelled");
//        }
//    }
//
//    public Order getOrderById(String id){
//        Order o = null;
//        for (int i = 0; i < size; i++) {
//            if(orders[i].getId().equals(id)) {
//                o = orders[i];
//                break;
//            }
//        }
//        return o;
//    }
}
