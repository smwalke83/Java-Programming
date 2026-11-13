import java.util.ArrayList;

public class BookStore {
    // list of books
    private ArrayList<Book> library;

    // constructors
    public BookStore() {

        // create and populate a list array of books that can be displayed and searched through
        library = new ArrayList<Book>();
        library.add(new Book("Intro to Java", "James", 56.99));
        library.add(new Book("Advanced Java", "Green", 65.99));
        library.add(new Book("Java Servlets", "Brown", 75.99));
        library.add(new Book("Intro to HTML", "James", 29.99));
        library.add(new Book("Intro to Flash", "James", 34.99));
        library.add(new Book("Advanced HTML", "Green", 56.99));
    }

    // toString method
    public String toString() {
        String result = "";
        for (Book tempBook: library) {
            result += tempBook.toString() + "\n";
        }
        return result;
    }

    // search method
    public ArrayList<Book> searchForTitle(String searchString) {
        ArrayList<Book> searchResult = new ArrayList<>();
        for (Book currentBook: library) {
            if (currentBook.getTitle().indexOf(searchString) != -1) {
                searchResult.add(currentBook);
            }
        }
        searchResult.trimToSize();
        return searchResult;
    }
}
