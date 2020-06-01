package suprun.andrei.styleoop.task8;

import java.util.Scanner;

/**
 * This class is used for calculation of value of function.
 * This function formula depends on the value of input parameter
 */
public class FunctionValue {

    /**
     * This method is used for displaying the value of function
     * depending on the value of input parameter
     */
    public static void getValueOfFunction(){
        double input= getInputNumber();
        if (input >= 3){
            System.out.printf("The value of the function is %.2f%n", getValueOfFunction1(input));
        } else {
            System.out.printf("The value of the function is %.2f%n", getValueOfFunction2(input));
        }
    }

    /**
     * This method is used for calculation the value of the function
     * when the input parameter is more than or equal to three
     * @param input double value received from console
     * @return value the value of the calculated function
     */
    public static double getValueOfFunction1(double input){
        double value = Math.pow(input, 2) - 3* input + 9;
        return value;
    }

    /**
     * This method is used for calculation the value of the function
     * when the input parameter is less than three
     * @param input double value received from console
     * @return value the value of the calculated function
     */
    public static double getValueOfFunction2(double input){
        double value = 1 / (Math.pow(input, 3) - 6);
        return value;
    }

    /**
     * This method is used for receiving input parameter from console
     * @return inputNumber double value received from console
     */
    public static double getInputNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid Input! Enter number:");
            scanner.next();
        }
        double inputNumber = scanner.nextDouble();
        return inputNumber;
    }
}
