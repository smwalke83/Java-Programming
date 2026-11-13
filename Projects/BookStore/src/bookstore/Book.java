package bookstore;

/**Book class
 */

public class Book {
    private String title;
    private String author;
    private double price;

    /**default constructor
     */
    public Book(){
        title = "";
        author = "";
    }

    /**Overloaded constructor
     * @param  newTitle  value to assign to title
     * @param  newAuthor value to assign to author
     * @param  newPrice value to assign to price
     */
    public Book(String newTitle, String newAuthor, double newPrice ){
        title = newTitle;
        author = newAuthor;
        price = newPrice;
    }

    /**getTitle method
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**getAuthor method
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**getPrice method
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**toString
     * @return title, author and price
     */
    @Override
    public String toString(){
        return ("title: " + title + "\t"
                + "author: "+ author + "\t"
                + "price: $" + price + "\t");
    }
}
