package classwork.Chapter7.Library;

public class Book {
    private String title;
    private String authorName;
    private double price;
    private int count;

    public Book(String title, String authorName, double price, int count) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.count = count;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
