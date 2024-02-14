package homework.braceChecker;

public class Stack {
    private char[] stack;
    int tos;

    Stack() {
        stack = new char[10];
        tos = -1;
    }

    private void extend() {
        char[] newArray = new char[stack.length + 10];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
        stack = newArray;

    }

    private void shorten() {
        if (stack.length - 10 > tos) {
            char[] newArray = new char[stack.length - 10];
            System.arraycopy(stack, 0, newArray, 0, tos + 1);
            stack = newArray;
        }
    }

    public void push(char i) {
        if (tos == (stack.length - 1)) {
            extend();
        }
        stack[++tos] = i;
    }

    public char pop() {
        char result;
        if (tos == -1) {
            System.out.println("Stack is Empty.");
            result = '*';
        } else {
            shorten();
            result = stack[tos];
            stack[tos] = 0;
            tos--;
        }
        return result;
    }

    public void print() {
        System.out.println("stack array size is: " + stack.length);
        for (char i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
