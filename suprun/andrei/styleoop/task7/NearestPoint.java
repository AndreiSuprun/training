package suprun.andrei.styleoop.task7;

import java.util.Scanner;

/**
 * This class is used for determining which of two points
 * is closest to the origin point
 */
public class NearestPoint {

    /**
     * This method is used for calculating and displaying the nearest to the origin point
     * from two given points
     */
    public static void isNearest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a coordinate x1");
        int x1 = getCoordinate(scanner);
        System.out.println("Enter a coordinate y1");
        int y1 = getCoordinate(scanner);
        System.out.println("Enter a coordinate x2");
        int x2 = getCoordinate(scanner);
        System.out.println("Enter a coordinate y2");
        int y2 = getCoordinate(scanner);
        double distanceOfPoint1 = Math.sqrt((x1*x1)+(y1*y1));
        double distanceOfPoint2 = Math.sqrt((x2*x2)+(y2*y2));
        if (distanceOfPoint1 < distanceOfPoint2) {
            System.out.println("The point with coordinates " + x1+", " + y1 + " is nearer to the origin point");
        } else System.out.println("The point with coordinates "+x2+","+ y2+ " is nearer to the origin point");}

    /**
     * This method is used for receiving one of the coordinates of the point from console
     * @param scanner java.util.Scanner instance used for reading value from console
     * @return inputValue double value of coordinate received from console
     */
    public static int getCoordinate(Scanner scanner){
         while (!scanner.hasNextInt()){
            System.out.println("Enter an integer number:");
            scanner.next();
         }
         int coordinate = scanner.nextInt();
         return coordinate;
    }
}
