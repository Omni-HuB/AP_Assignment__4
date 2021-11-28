package Question_2;

/*                       _________ PROBLEM STATEMENT _________

An image is a matrix of pixels. You must have seen two types of images: color and grayscale.
A color image pixel has three colors: Red, Green, and Blue, but a grayscale image
pixel has only one color: Gray. Regardless of the image type, a color always has an 8-bit
integer value (0-255) associated with it. You need to implement a program that can input,
create, update and display the images (matrices). It should be able to compute their negatives
(matrices) as well. NOTE: You need to generalize the computation of negatives, for we only
need to subtract the color values from 255, regardless of the image type.
"""
*/
import java.util.*;

public class __Run_Pixel_Matrix__ {
    static int N;
    static int M;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the size of Image_matrix ");
        System.out.print("Enter the length(Rows) ");
        M = sc.nextInt();
        System.out.print("Enter the width(columns) ");
        N = sc.nextInt();

        System.out.println("""
                  1.Enter Image-Matrix Manually
                  2.Obtain a Automated Image-Matrix
                  3.Update the existing Image-Matrix
                  4.Delete a pixel in Image-Matrix
                  5.Exit
                """);

        System.out.println("Enter your choice :");

        int choice = sc.nextInt();
        do {
            switch (choice) {
                case 1:
                    Pixel.enterManually();
                    break;
                case 2:
                    Pixel.Automated();
                    break;
                case 3:
                    Pixel.update();
                    break;
                case 4:
                    Pixel.delete();
                    break;
                case 5:
                    break;
            }
            System.out.println("\nEnter your choice :");
            choice=sc.nextInt();
        }while (choice!=5);

    }
}






