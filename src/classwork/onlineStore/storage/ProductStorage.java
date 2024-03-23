package classwork.onlineStore.storage;

import classwork.onlineStore.model.Product;
import classwork.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class ProductStorage implements Serializable {

    private Product[] products = new Product[10];
    private int size;
    public void add(Product product){
        if(products.length == size){
            extend();
        }
        products[size++] = product;
        StorageSerializeUtil.serialiseProductStorage(this);

    }
    
    public Product getById(String id){
        for (int i = 0; i < size; i++) {
            if(products[i].getId().equals(id) && !products[i].isRemoved()){
                return products[i];
            }
        }
        return null;
    }

    private void extend(){
        Product[] temp = new Product[products.length + 10];
        System.arraycopy(products, 0, temp, 0, products.length);
        products = temp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            if(!products[i].isRemoved()) {
                System.out.println(products[i]);
            }
        }
    }

}
