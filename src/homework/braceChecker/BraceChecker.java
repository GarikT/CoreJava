package homework.braceChecker;

public class BraceChecker {
    private String text;

    public BraceChecker(String s) {
        text = s;
    }

    public void check() {
        char ch;
        char popped;
        Stack stack = new Stack();
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    popped = stack.pop();
                    if( popped == '*'){
                        System.out.println( ch + " brace closed at " + i + ", but no matching opening brace was found");
                    } else if (popped != '(' && popped != '*') {
                        System.out.println("Error: opened " + popped + " but closed " + ch + " at " + i);
                    }
                    break;
                case '}':
                    popped = stack.pop();
                    if( popped == '*'){
                        System.out.println( ch + " brace closed at " + i + ", but no matching opening brace was found");
                    } else if (popped != '{' && popped != '*') {
                        System.out.println("Error: opened " + popped + " but closed " + ch + " at " + i);
                    }
                    break;
                case ']':
                    popped = stack.pop();
                    if( popped == '*'){
                        System.out.println( ch + " brace closed at " + i + ", but no matching opening brace was found");
                    } else if (popped != '[' && popped != '*') {
                        System.out.println("Error: opened " + popped + " but closed " + ch + " at " + i);
                    }
                    break;
            }
        }
        if(stack.tos != -1){
            System.out.println("There are brace[s] in the text that's been opened but not closed");
        }
    }
}
