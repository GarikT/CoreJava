package classwork.onlineStore.storage;

import classwork.onlineStore.model.User;
import classwork.onlineStore.util.StorageSerializeUtil;
import homework.Store.enums.UserType;

import java.io.Serializable;

public class UserStorage implements Serializable {

    private User[] users = new User[10];
    private int size;
    public void add(User user){
        if(users.length == size){
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serialiseUserStorage(this);

    }

    private void extend(){
        User[] temp = new User[users.length + 10];
        System.arraycopy(users, 0, temp, 0, users.length);
        users = temp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public User getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if(users[i].getEmail().equals(email)){
                return users[i];
            }
        }
        return null;
    }

    public void printByType(UserType userType) {
        for (int i = 0; i < size; i++) {
            if(users[i].getUserType() == userType){
                System.out.println(users[i]);
            }
        }
    }
}
