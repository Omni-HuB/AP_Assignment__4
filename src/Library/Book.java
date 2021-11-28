package Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Book {

    private String title;                   // Title of the book
    private int ISBNs;                      // ISBNs of the book
    private int barcode;                    // Barcode of the book

    static ArrayList<ArrayList<Book>>bookDetails = new ArrayList<>();
    static ArrayList<Book> bookShelf = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public Book(String title, int ISBNs, int barcode) {
        this.title = title;
        this.ISBNs = ISBNs;
        this.barcode = barcode;
    }

                 //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBNs(int ISBNs) {
        this.ISBNs = ISBNs;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

             //Getters
    public String getTitle() {
        return title;
    }

    public int getISBNs() {
        return ISBNs;
    }

    public int getBarcode() {
        return barcode;
    }

    public String toString() {
        return this.title + " " + this.ISBNs + " " + this.barcode;
    }


    public static void enterManually() {
        String title;
        int ISBNs;
        int barcode;

        for (int i = 0; i < __Run_Library__.N; i++) {

            System.out.println("Enter the book" + (i + 1) + " Details-- ");
            sc.nextLine();
            System.out.print("Enter Book Title: ");
            title = sc.nextLine();

            System.out.print("\nEnter Book ISBNs : ");
            ISBNs = sc.nextInt();

            System.out.print("\nEnter Book Barcode : ");
            barcode = sc.nextInt();

            Book book = new Book(title, ISBNs, barcode);

            bookShelf.add(book);

            bookShelf.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getISBNs).thenComparing(Book::getBarcode));

            book.setBarcode(barcode);
            book.setTitle(title);
            book.setISBNs(ISBNs);

        }
    }

    public static void inputsFromGivenData() throws FileNotFoundException {
        String title;
        int ISBNs;
        int barcode;
        System.out.println("Enter the pathLocation of the data file -->");
        String pathname=sc.nextLine();

        File dataReader = new File(pathname);
        Scanner myReader = new Scanner(dataReader);
        String[] store;
        for (int i = 0; i < __Run_Library__.K; i++) {

            for (int j = 0; j < __Run_Library__.slots; j++){

                store =myReader.nextLine().strip().split(" ");
               // System.out.println(Arrays.toString(store));

                title=store[0];
                ISBNs=Integer.parseInt(store[1]);
                barcode=Integer.parseInt(store[2]);

                Book book = new Book(title, ISBNs, barcode);
                bookShelf.add(book);

                bookShelf.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getISBNs).thenComparing(Book::getBarcode));

                book.setBarcode(barcode);
                book.setTitle(title);
                book.setISBNs(ISBNs);

            }

        }

    }

    public static  void searchBook(){
        String title;
        int ISBNs;
        int barcode;
        String bookPosition= "";

        sc.nextLine();
        System.out.print("\nEnter Book Title: ");
        title = sc.nextLine();
        title=title+",";
        System.out.print("\nEnter Book ISBNs : ");
        ISBNs = sc.nextInt();
        System.out.print("\nEnter Book Barcode : ");
        barcode = sc.nextInt();

        for (int i=0;i<__Run_Library__.K;i++) {
            for (int j = 0; j < __Run_Library__.slots; j++) {
              bookPosition=Integer.toString(bookDetails.get(i).indexOf(new Book(title,ISBNs,barcode)));
            }

        }

        System.out.println(" Book position is :"+ bookPosition);
    }


    public static void main(String[] args){

        for (int i = 0; i < __Run_Library__.K; i++) {
                bookDetails.add(new ArrayList<Book>());
                for (int j = 0; j < __Run_Library__.slots; j++) {
                    bookDetails.get(i).add(j,bookShelf.get((i * __Run_Library__.K) + j));
                }
            }

            bookDetails.forEach(System.out::println);

        }
}

