package classwork.chapter14.collection;

import classwork.chapter12.Language;
import classwork.chapter12.User;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, User> myMap = new HashMap<>();
        myMap.put("poxos@mail.com", new User("Poxos", "Poxosyan", "poxos@mail.com", Language.RU));
        myMap.put("petros@mail.com", new User("petros", "Poxosyan", "petros@mail.com", Language.RU));
        myMap.put("martiros@mail.com", new User("Martiros", "Martirosyan", "Martiros@mail.com", Language.ENG));
        //User user = myMap.get(null);
        //System.out.println(user);

//        for (String key : myMap.keySet()) {
//            System.out.println(key + " -> " + myMap.get(key));
//        }
//
//        for (User value : myMap.values()) {
//            System.out.println(value);
//        }
        for (Map.Entry<String, User> entry : myMap.entrySet()) {
            //System.out.println(entry.getKey() + "->" + entry.getValue());
            System.out.println(entry);
        }
    }
}
