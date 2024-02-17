package homework.braceChecker;

public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker bc = new BraceChecker("]Hello, {this (is) a text]");
        bc.check();
    }
}
