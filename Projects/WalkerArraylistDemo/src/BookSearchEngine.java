import java.util.ArrayList;
import java.util.Scanner;

public class BookSearchEngine {
    // main function for book search
    public static void main(String[] args) {

        // instantiate bookstore object and scanner objcet
        BookStore bs = new BookStore();
        Scanner scan = new Scanner(System.in);

        // display book collection to user (I moved this before the user prompt for a search term, which made more sense to me
        System.out.println("Our book collection is: ");
        System.out.println(bs.toString());

        // Prompt user for search term, then populate an array list of books with positive results, and display it to the user
        System.out.print("Enter a keyword > ");
        String keyword = scan.next();
        ArrayList<Book> results = bs.searchForTitle(keyword);
        System.out.println("The search results for " + keyword + " are: ");
        for (Book tempBook: results) {
            System.out.println(tempBook.toString());
        }
    }
}
