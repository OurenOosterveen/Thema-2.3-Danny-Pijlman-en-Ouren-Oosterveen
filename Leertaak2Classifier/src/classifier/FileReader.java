package classifier;

/**
 * Created by ouren on 21-2-2016.
 */
import java.io.File;
import java.util.Scanner;
public class FileReader {
    private static final String RESULTS_FILE = "/OptieText.txt";
    private static final String CAT_FILE = "./classifier/CatText.txt";

    public static void main(String[] args) throws Exception {
        // Create a File instance
        File file = new java.io.File(CAT_FILE);
                // Create a Scanner for the file
        Scanner input = new Scanner(file);
                // Read data from a file
        while (input.hasNext()) {
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(
                     firstName + " " + mi + " " + lastName + " " + score);
             }

         // Close the file
         input.close();
         }
     }