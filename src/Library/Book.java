package Library;

import java.util.*;

public class Book {

    private String title;                   // Title of the book
    private int ISBNs;                      // ISBNs of the book
    private int barcode;                    // Barcode of the book

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
        return " " + this.title + " , " + this.ISBNs + " , " + this.barcode + " ";

    }

    static ArrayList<ArrayList<Book>> bookDetails = new ArrayList<>();
    static ArrayList<Book> bookShelf = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void enterManually() {
        String title;
        int ISBNs;
        int barcode;

        for (int i = 0; i < __Run_Library__.N; i++) {

            System.out.println("Enter the book" + i + 1 + " Details-- ");
            sc.nextLine();
            System.out.print("\nEnter Book Title: ");
            title = sc.nextLine();
            System.out.print("\nEnter Book ISBNs : ");
            ISBNs = sc.nextInt();
            System.out.print("\nEnter Book Barcode : ");
            barcode = sc.nextInt();

            Book book = new Book(title, ISBNs, barcode);
            //book.enterBookDetails();
            bookShelf.add(book);

            Collections.sort(bookShelf, Comparator.comparing(Book::getTitle).thenComparing(Book::getISBNs).thenComparing(Book::getBarcode));

            book.setBarcode(barcode);
            book.setTitle(title);
            book.setISBNs(ISBNs);
            //Collections.sort(bookDetails.get(i),new CompareBy());
        }
    }

    public static void main(String[] args){

        for (int i = 0; i < __Run_Library__.K; i++) {
                bookDetails.add(new ArrayList<Book>());
                for (int j = 0; j < __Run_Library__.slots; j++) {
                    bookDetails.get(i).add(j, bookShelf.get((i * __Run_Library__.K) + j));
                }
            }

            bookDetails.forEach(System.out::println);

        }

}

//
//class CompareBy implements Comparator<Book> {
//    @Override
//    public int compare(Book o1, Book o2) {
//        if (o1.getTitle().equals(o2.getTitle())) {
//            if (o1.getISBNs() == (o2.getISBNs())) {
//                if (o1.getBarcode() < o2.getBarcode()) return -1;
//                else if {
//                    return 0;
//                }
//            } else if (o1.getISBNs() < o2.getISBNs()) return -1;
//        }
//
//        return o1.getTitle().compareTo(o2.getTitle());
//    }
//}




