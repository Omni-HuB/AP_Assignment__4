package Question_1;


/*                                       _________ PROBLEM STATEMENT _________

* You wanted to open a library, so you have bought N books and K racks (having N/K
slots). All these books are currently just lying on the floor. Fortunately, you have the titles,
ISBNs, and barcodes of the books on the bills you have received.
*
*
* You want to now arrange these books on the racks based on the book titles, just like words in the pages of a dictionary.
However, sometimes, the titles of the books may match; you plan to use their ISBN for
sorting in such cases. If ISBNs also match, you think of using their barcodes. Write a
program to create the required data from the bills you have, sort the data as you have planned,
and identify the appropriate slot for any book you pick from the floor for placing it as per the
plan.
*/

import java.io.FileNotFoundException;
import java.util.*;
public class __Run_Library__ {


        static int N ;                                     // Number of Books
        static int K;                                      // Number of racks
        static int slots;                                  // A matrix having of N/K slots (columns) in each rack (Row)


    // static List<List<Book>> bookDetails = new ArrayList<List<Book>>();




    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the Number of BOOKS :: ");
        N = sc.nextInt();

        System.out.print("\nEnter the Number of racks :: ");
        K = sc.nextInt();

        slots = N / K;
        System.out.println("The Number of Slots are :: " + slots);

        System.out.println("""
            1.Enter book Details Manually
            2.Input book Details from Bill(.txt file)
            3.Exit
            """);
        System.out.print( "Enter your choice : ");
        int choice=sc.nextInt();

        switch(choice){
            case 1:
            {
                Book2.enterManually();
                Book2.main(args);
                Book2.searchBook();
                return;
            }
            case 2:
            {
                Book2.inputsFromGivenData();
                Book2.main(args);
                Book2.searchBook();
                return;

            }
            case 3:
                break;
        }


    }

}


