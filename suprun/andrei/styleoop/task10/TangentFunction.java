package suprun.andrei.styleoop.task10;

import java.util.Scanner;

/**
 * This class is used for calculation of function f(x) = tg(x)
 * for a range of input parameters (initialValueOfRange, endValueOfRange)
 * with step stepOfCalculation.
 */
public class TangentFunction {

    /**
     * This method is used for calculation of function f(x) = tg(x)
     * for input parameter input
     * @param input value of function parameter x
     * @return value value of function f(x) = tg(x) for input parameter input
    */
    public static double calculateTangentFunction(double input){
        double value = Math.tan(input);
        return value;
    }

    /**
     * This method displays table with value of function f(x) = tg(x)
     * for a range of input parameters (initialValueOfRange, endValueOfRange)
     * with step stepOfCalculation
     */
    public static void getOutput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an initial value of a range:");
        double initialValueOfRange = getValue(scanner);
        System.out.println("Enter an end value of a range:");
        double endValueOfRange = getValue(scanner);
        if (endValueOfRange < initialValueOfRange) {
            System.out.println("The initial value of the range"+initialValueOfRange+
                    " must be less than the end value of a range:");
            System.out.println("Enter an end value of a range:");
            endValueOfRange = getValue(scanner);
        }
        System.out.println("Enter step of calculation:");
        double stepOfCalculation = getValue(scanner);
        System.out.printf("%-10s %-12s%n-------------------%n", "    x", "tg(x)");
        for (double i=initialValueOfRange; i< endValueOfRange; i+=stepOfCalculation){
            System.out.printf("%6.2f %8.2f%n", i, calculateTangentFunction(i));
        }
    }

    /**
     * This method is used for receiving input parameter from console
     * @param scanner java.util.Scanner instance used for reading value from console
     * @return inputValue double value received from console
     */
    public static double getValue(Scanner scanner){
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid Input! Enter number:");
            scanner.next();
        }
        double inputValue = scanner.nextDouble();
        return inputValue;
    }

}





