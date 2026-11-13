import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClassicMovies {
    public static void main(String[] args) {
        File file = new File("out/production/WalkerExceptionDemo/data/movies.txt");
        int counter = 0;
        try {
            Scanner scan = new Scanner(file);
            while (counter < 5) {
                String movieTitle = scan.nextLine();
                if (!scan.hasNextInt()) {
                    System.out.println("Invalid file format.");
                    String invalidData = scan.nextLine();
                }
                int runningTime = scan.nextInt();
                if (scan.hasNextLine()) {
                    String newLine = scan.nextLine();
                }
                System.out.println(movieTitle + ", " + runningTime + " minutes");
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + " Unable to find movies.txt, exiting.");
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage() + " Attempt to read past end of file.");
        }
    }
}
