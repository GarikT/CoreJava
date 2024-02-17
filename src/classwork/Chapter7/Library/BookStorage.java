package classwork.Chapter7.Library;

public class BookStorage {
    private Book[] books = new Book[10];
    private int size;
    public void add(Book book) {
        if(size == books.length){
            extend();
        }
        books[size++] = book;
    }

    private void extend(){
        Book[] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, books.length);
        books = tmp;
    }

    public void print(){
        Book b;
        for (int i = 0; i < size; i++) {
            b = books[i];
            System.out.println(b.getTitel() + " " + b.getAuthorName() + " " +
                    b.getPrice() + " " + b.getCount());
        }
    }

    public void search(String keyword){
        Book b;
        for (int i = 0; i < size; i++) {
            b = books[i];
            if(b.getTitel().contains(keyword)
                    || b.getAuthorName().contains(keyword)) {
                System.out.println(b.getTitel() + " " + b.getAuthorName() + " " +
                        b.getPrice() + " " + b.getCount());
            }
        }
    }
}
