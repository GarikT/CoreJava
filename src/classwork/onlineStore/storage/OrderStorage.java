package classwork.onlineStore.storage;

import classwork.onlineStore.model.Order;
import classwork.onlineStore.model.User;
import classwork.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {

    private Order[] orders = new Order[10];
    private int size;
    public void add(Order order){
        if(orders.length == size){
            extend();
        }
        orders[size++] = order;
        StorageSerializeUtil.serialiseOrderStorage(this);
    }

    private void extend(){
        Order[] temp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, temp, 0, orders.length);
        orders = temp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    public Order getById(String id) {
        for (int i = 0; i < size; i++) {
            if(orders[i].getId().equals(id)){
                return orders[i];
            }
        }
        return null;
    }

    public void printByUser(User user) {
        for (int i = 0; i < size; i++) {
            if(orders[i].getUser().equals(user))
                System.out.println(orders[i]);
        }
    }
}
