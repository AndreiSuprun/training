package suprun.andrei.styleoop.task3;

import java.util.Scanner;

/**
 * This class is used for calculation of the area of the inscribed square
 * and the area ratio of the described and the inscribed squares
 */
public class SquareArea {

    /**
     * This method is used for displaying of the area of the inscribed square
     *  and the area ratio of the described and the inscribed squares
     */
    public static void getOutput(){
        double areaOfDescribedSquare = getUserInput();
        System.out.printf("The area of the inscribed square is %.2f%n", getAreaOfInscribedSquare(areaOfDescribedSquare));
        System.out.printf("The area ratio of the squares is %.2f%n", getAreaRatio(areaOfDescribedSquare));
    }

    /**
     * This method is used for calculation of area ratio of the described and the inscribed squares
     * @param areaOfDescribedSquare the double value of area of the described square
     * @return areaRatio the double value of area ratio of the described and the inscribed squares
     */
    public static double getAreaRatio(double areaOfDescribedSquare) {
        double areaRatio = areaOfDescribedSquare/getAreaOfInscribedSquare(areaOfDescribedSquare);
        return areaRatio;
    }

    /**
     * This method is used for calculation of area of the inscribed squares
     * @param areaOfDescribedSquare the double value of area of the described square
     * @return areaOfInscribedSquare the double value of area ratio of the inscribed squares
     */
    public static double getAreaOfInscribedSquare(double areaOfDescribedSquare) {
        double diameterOfCircle = Math.sqrt(areaOfDescribedSquare);
        double areaOfInscribedSquare = Math.pow(Math.sqrt(Math.pow(diameterOfCircle,2) / 2), 2);
        return areaOfInscribedSquare;
    }

    /**
     * This method is used for calculation of the diameter of circle
     * @return diameterOfCircle the double value of the diameter of the circle the inscribed squares
     */
    public static double getDiameterOfCircle(){
        double diameterOfCircle = Math.sqrt(getUserInput());
        return diameterOfCircle;
    }

    /**
     * This method is used for receiving the area of the described square from console
     * @return areaOfDescribedSquare the double value of area of the described square
     */
    public static double getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the area of the described square:");
        while (!scanner.hasNextDouble()){
            System.out.println("Invalid input! Enter a number:");
            scanner.next();
        }
        double areaOfDescribedSquare = scanner.nextDouble();
        return areaOfDescribedSquare;
    }
}
