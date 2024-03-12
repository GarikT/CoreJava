package homework.Store.storage;

import homework.Store.enums.UserType;
import homework.Store.model.User;

public class UserStorage {
    private User[] users = new User[10];
    private int size;

    public UserStorage() {
        size = 0;
    }

    public void addUser(User user){
        if(size >= users.length){
            extend();
        }
        users[size] = user;
        size++;
    }

    private void extend(){
        if(size >= users.length){
            User[] temp = new User[users.length + 10];
            System.arraycopy(users, 0, temp, 0, users.length);
            users = temp;
        }
    }

    public void printRegularUsers(){
        if(size <= 0){
            System.out.println("No users at this time");
        }else{
            for (int i = 0; i < size; i++) {
                if(users[i].getType().equals(UserType.USER)){
                    System.out.println(users[i]);
                }
            }
        }
    }


    public boolean checkUser(String id, String password) {
        boolean result = false;
        if(size > 0){
            for (int i = 0; i < size; i++) {
                if(users[i].getId().equals(id) && users[i].getPassword().equals(password)){
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean isAdmin(String idFromUser) {
        boolean result = false;
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                if (users[i].getId().equals(idFromUser)) {
                    if (users[i].getType().equals(UserType.ADMIN)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public User getUser(String id, String password){
        User result = null;
        for (int i = 0; i < size; i++) {
            if(users[i].getId().equals(id) && users[i].getPassword().equals(password)){
                result = users[i];
                break;
            }
        }
        return result;
    }
}
