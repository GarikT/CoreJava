package classwork.chapter14.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> mySet = new LinkedHashSet<>();
        mySet.add(5);
        mySet.add(4);
        mySet.add(8);
        mySet.add(1);
        mySet.add(800);
        mySet.add(-6);
        mySet.add(70);
        mySet.add(58);
        mySet.add(8001);

        for (Integer i : mySet) {
            System.out.println(i);
        }
    }
}
