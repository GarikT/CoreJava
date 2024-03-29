package classwork.chapter14.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionTest {
    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("poxos");
//        names.add("petros");
//        for (String name : names) {
//            System.out.println(name);
//        }
//        names.remove(0);
//        for (String name : names) {
//            System.out.println(name);
//        }
//        List<Integer> numbers = new LinkedList<>();
//        numbers.add(5);
//        numbers.add(50);
//        numbers.add(6);
//
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }
//        System.out.println("--------");
//        numbers.remove(1);
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        Queue<String> myQueue = new PriorityQueue<>();
        myQueue.add("Poxos");
        myQueue.add("Aram");
        myQueue.add("Zaven");
        myQueue.add("Zaven");
        for (String s : myQueue) {
            System.out.println(s);
        }

        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
}
