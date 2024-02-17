package classwork.Chapter7.Library;

public class Book {
    private String titel;
    private String authorName;
    private double price;
    private int count;

    public Book(String titel, String authorName, double price, int count) {
        this.titel = titel;
        this.authorName = authorName;
        this.price = price;
        this.count = count;
    }

    public Book() {
    }

    public String getTitel() {
        return titel;
    }

    public String getAuthorName() {
        return authorName;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
