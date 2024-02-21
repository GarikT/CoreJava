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
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void search(String keyword){
        Book b;
        for (int i = 0; i < size; i++) {
            b = books[i];
            if(b.getTitle().contains(keyword)
                    || b.getAuthorName().contains(keyword)) {
                System.out.println(b.getTitle() + " " + b.getAuthorName() + " " +
                        b.getPrice() + " " + b.getCount());
            }
        }
    }
}
