package Question_2;

/*                       _________ PROBLEM STATEMENT _________

An image is a matrix of pixels. You must have seen two types of images: color and grayscale.
A color image pixel hasthree colors: Red, Green, and Blue, but a grayscale image
pixel has only one color: Gray. Regardless of the image type, a color always has an 8-bit
integer value (0-255) associated with it. You need to implement a program that can input,
create, update and display the images (matrices). It should be able to compute their negatives
(matrices) as well. NOTE: You need to generalize the computation of negatives, for we only
need to subtract the color values from 255, regardless of the image type.
"""
*/

import java.util.*;
public class Pixel<V> {

     V rValue;
     V bValue;
     V gValue;

    public Pixel(V rValue, V bValue, V gValue) {
        this.rValue = rValue;
        this.bValue = bValue;
        this.gValue = gValue;
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Pixel<Byte>>> image=new ArrayList<>();

    public String toString() {
        return this.rValue + " " + this.bValue + " " + this.gValue;
    }

    public static void Automated() {
        byte rValue;
        byte gValue;
        byte bValue;

        for (int i = 0; i < __Run_Pixel_Matrix__.M; i++) {
            image.add(new ArrayList<>());
            for (int j = 0; j < __Run_Pixel_Matrix__.N; j++) {

                System.out.print("\nEnter Red(R) Value: ");
                rValue = (byte)(Math.random()*255);
                System.out.print("\nEnter Blue(B) Value: ");
                bValue =(byte)(Math.random()*255);
                System.out.print("\nEnter Green(G) Value: ");
                gValue = (byte)(Math.random()*255);

                Pixel<Byte> pixel = new Pixel<>(rValue, bValue, gValue);

                image.get(i).add(j, pixel);
            }
        }
    }
    public static void enterManually(){
        byte rValue;
        byte gValue;
        byte bValue;

         for (int i = 0; i < __Run_Pixel_Matrix__.M; i++) {
             image.add(new ArrayList<>());
             for (int j = 0; j < __Run_Pixel_Matrix__.N; j++) {

                 //ArrayList<Byte> pixelValues=new ArrayList<>();
                 System.out.print("\nEnter Red(R) Value: ");
                 rValue=sc.nextByte();
                 System.out.print("\nEnter Blue(B) Value: ");
                 bValue=sc.nextByte();
                 System.out.print("\nEnter Green(G) Value: ");
                 gValue=sc.nextByte();

                 Pixel<Byte> pixel=new Pixel<>(rValue,bValue,gValue);

                 image.get(i).add(j,pixel);
             }
         }

        image.forEach(System.out::println);
        }

    public static void update(){
        byte rValue;
        byte gValue;
        byte bValue;

        System.out.print("Enter the row at which update is required: ") ;
        int row=sc.nextInt();
        System.out.print("Enter the column at which update is required: ") ;
        int column=sc.nextInt();

        System.out.print("\nEnter Red(R) Value: ");
        rValue=sc.nextByte();
        System.out.print("\nEnter Blue(B) Value: ");
        bValue=sc.nextByte();
        System.out.print("\nEnter Green(G) Value: ");
        gValue=sc.nextByte();

        Pixel<Byte> pixel=new Pixel<>(rValue,bValue,gValue);
        image.get(row).add(column,pixel);
        image.forEach(System.out::println);
    }

    public static void delete() {
        byte rValue;
        byte gValue;
        byte bValue;
        System.out.print("\nEnter the row at which pixel is to be deleted : ");
        int row = sc.nextInt();
        System.out.print("\nEnter the column at which pixel is to be deleted: ");
        int column = sc.nextInt();
        rValue = (image.get(row).get(column).rValue);

        bValue = (image.get(row).get(column).rValue);

        gValue =(image.get(row).get(column).rValue) ;

        image.get(row).remove(column);
        Pixel<Byte> pixel2 = new Pixel<>((byte) 0,(byte) 0,(byte) 0);
        image.get(row).add(column,pixel2);
        image.forEach(System.out::println);
    }

        public static void negativesOfImageMatrix() {
            byte rValue;
            byte gValue;
            byte bValue;
            for (int i = 0; i < __Run_Pixel_Matrix__.M; i++) {
                image.add(new ArrayList<>());
                for (int j = 0; j < __Run_Pixel_Matrix__.N; j++) {

                    rValue = (byte) (255 - image.get(i).get(j).rValue + 1);

                    bValue = (byte) (255 - image.get(i).get(j).bValue + 1);

                    gValue = (byte) (255 - image.get(i).get(j).gValue + 1);

                    Pixel<Byte> pixel = new Pixel<>(rValue, bValue, gValue);
                    image.get(i).add(j, pixel);

                }


            }
            image.forEach(System.out::println);
    }

}












