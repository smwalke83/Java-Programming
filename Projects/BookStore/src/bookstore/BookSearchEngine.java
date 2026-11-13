package bookstore;

import javax.swing.*;
import java.util.ArrayList;

/**BookSearchEngine Class
 */
public class BookSearchEngine {
    public static void main(String[] args){
        BookStore bs = new BookStore();

        System.out.println("Our book collection is");
        System.out.println(bs.toString());

        String keyword = JOptionPane.showInputDialog(null,
                "Enter a keyword: ");

        ArrayList<Book> results = bs.searchForTitle(keyword);
        System.out.println("The search results are: ");
        for(Book temp: results)
             System.out.println(temp.toString());

    }
}
