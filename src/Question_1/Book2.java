package Question_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Book2 <T,I,B> {

        T title;                   // Title of the book
        I ISBNs;                      // ISBNs of the book
        B barcode;                    // Barcode of the book

        static ArrayList<ArrayList<Book2<String,Long,Long>>>bookDetails = new ArrayList<>();
        static ArrayList<Book2<String,Long,Long>> bookShelf = new ArrayList<>();
        static Scanner sc = new Scanner(System.in);


        public Book2(T title, I ISBNs, B barcode) {
            this.title = title;
            this.ISBNs = ISBNs;
            this.barcode = barcode;
        }

        //Setters
        public void setTitle(T title) {
            this.title = title;
        }

        public void setISBNs(I ISBNs) {
            this.ISBNs = ISBNs;
        }

        public void setBarcode(B barcode) {
            this.barcode = barcode;
        }

        //Getters
        public  T getTitle() {
            return title;
        }

        public I getISBNs() {
            return ISBNs;
        }

        public B getBarcode() {
            return barcode;
        }

        public String toString() {
            return this.title + " " + this.ISBNs + " " + this.barcode;
        }


        public static void enterManually() {
            String title;
            long ISBNs;
            long barcode;

            for (int i = 0; i < __Run_Library__.N; i++) {

                System.out.println("Enter the book" + (i + 1) + " Details-- ");
                sc.nextLine();
                System.out.print("Enter Book Title: ");
                title = sc.nextLine();

                System.out.print("\nEnter Book ISBNs : ");
                ISBNs = sc.nextLong();

                System.out.print("\nEnter Book Barcode : ");
                barcode = sc.nextLong();

                Book2<String,Long,Long> book = new Book2<String,Long,Long>(title, ISBNs, barcode);

                bookShelf.add(book);

                bookShelf.sort(Comparator.comparing(Book2<String,Long,Long>::getTitle).thenComparing(Book2<String,Long,
                        Long>::getISBNs).thenComparing(Book2<String,Long,Long>::getBarcode));

                book.setBarcode(barcode);
                book.setTitle(title);
                book.setISBNs(ISBNs);

            }
        }

        public static void inputsFromGivenData() throws FileNotFoundException {
            String title;
            long ISBNs;
            long barcode;
            System.out.println("Enter the pathLocation of the data file(like C:\\\\Users\\\\User\\\\Desktop\\\\data.txt) -->");     //like C:\\Users\\User\\Desktop\\data
            // .txt
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

                    Book2<String,Long,Long> book = new Book2<String,Long,Long>(title, ISBNs, barcode);
                    bookShelf.add(book);

                    bookShelf.sort(Comparator.comparing(Book2<String,Long,Long>::getTitle).thenComparing(Book2<String,Long,Long>::getISBNs).thenComparing(Book2<String,Long,Long>::getBarcode));

                    book.setBarcode(barcode);
                    book.setTitle(title);
                    book.setISBNs(ISBNs);

                }

            }

        }

        public static  void searchBook(){
            String title;
            long ISBNs;
            long barcode;
            String bookPosition= "";

            sc.nextLine();
            System.out.print("\nEnter Book Title: ");
            title = sc.nextLine();

            System.out.print("\nEnter Book ISBNs : ");
            ISBNs = sc.nextLong();
            System.out.print("\nEnter Book Barcode : ");
            barcode = sc.nextLong();

            for (int i=0;i<__Run_Library__.K;i++) {
                for (int j = 0; j < __Run_Library__.slots; j++) {

                    // bookPosition=String.valueOf(bookDetails.get(0).get(2));              ///this works

                    bookPosition=String.valueOf(bookDetails.get(i).indexOf(new Book2<String, Long,Long>(title,ISBNs,
                            barcode))) ;
                }

            }

            System.out.println(" Book position is :"+ bookPosition);
        }


        public static void main(String[] args){

            for (int i = 0; i < __Run_Library__.K; i++) {
                bookDetails.add(new ArrayList<>());
                for (int j = 0; j < __Run_Library__.slots; j++) {
                    bookDetails.get(i).add(j,bookShelf.get((i * __Run_Library__.K) + j));
                }
            }

            bookDetails.forEach(System.out::println);

        }
    }



