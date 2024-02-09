package classwork.chapter6.stack;

public class StackTest {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(55);
        myStack.push(66);
        myStack.push(66);
        myStack.push(66);
        myStack.push(66);
        myStack.push(66);
        myStack.push(66);
        myStack.push(66);
        myStack.push(66);
        myStack.push(6);
        myStack.push(77);
//        int a = myStack.pop();
//        int b = myStack.pop();
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        //System.out.println(b);
    }
}
