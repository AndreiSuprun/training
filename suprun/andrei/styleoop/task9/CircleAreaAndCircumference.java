package suprun.andrei.styleoop.task9;

import java.util.Scanner;

/**
 * This class is used for calculation of the area and the circumference
 * of the circle of the given radius
 */
public class CircleAreaAndCircumference {

    /**
     * This method is used for displaying the area and the circumference
     * of the circle depending on the value of its radius
     */
    public static void getOutput(){
        double radius = getInputRadius();
        System.out.printf("Area of circle: %.2f%nCircumference of circle: %.2f%n",
                getAreaOfCircle(radius), getCircumferenceOfCircle(radius));
    }

    /**
     * This method is used for calculation the area of the circle
     * when the input parameter is its radius
     * @param radius double value of the radius received from console
     * @return area the value of the area of the circle
     */
    public static double getAreaOfCircle(double radius){
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    /**
     * This method is used for calculation the circumference of the circle
     * when the input parameter is its radius
     * @param radius double value of the radius received from console
     * @return circumference the value of the circumference of the circle
     */
    public static double getCircumferenceOfCircle(double radius){
        double circumference = 2 * Math.PI * radius;
        return circumference;
    }
    public static double getInputRadius(){
        Scanner scanner = new Scanner(System.in);
        double inputRadius;
        do {
            System.out.println("Enter circle radius:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid Input! Enter number:");
            scanner.next();
        }
        inputRadius = scanner.nextDouble();
        } while (inputRadius <= 0);
        return inputRadius;
    }
}
