package bookstore;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**BookStore class
*/
public class BookStore {
    private ArrayList<Book> library;

    /** default constructor
     * instantiates and initializes Arraylist of Books
     */
    public BookStore(){
        library = new ArrayList<>();
        library.add(new Book("Intro to Java", "James", 56.99));
        library.add(new Book("Advanced Java", "Green", 65.99));
        library.add(new Book("Java Servlets", "Brown", 75.99));
        library.add(new Book("Intro to HTML", "James", 29.49));
        library.add(new Book("Intro to Flash", "James", 34.99));
        library.add(new Book("Advanced HTML", "Green", 56.99));
        library.trimToSize();
    }

    /**toString
     * @return each book in library, one at a time
     */
    @Override
    public String toString(){
        String result = "";
        for(Book temp: library){
            result += temp.toString() + "\n";
        }

        return result;
    }

    /**Generates list of books containing searchString
     * @param  searchString  the keyword to search for
     * @return  the Arraylist of books containing the keyword
     */
    public ArrayList<Book> searchForTitle(String searchString){
        ArrayList<Book> searchResult = new ArrayList<Book>();
        for(Book currentBook : library){
            if(currentBook.getTitle().indexOf(searchString) != -1){
                searchResult.add(currentBook);
            }
        }
        searchResult.trimToSize();
        return searchResult;
    }
}
