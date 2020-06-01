package suprun.andrei.styleoop.task1;

import java.util.Scanner;

/**
 * This class is used for calculation of the last digit of the square of the last digit
 * of the input number
 */
public class SquareOfLastDigit {

    /**
     * This method is used for calculation and displaying of the last digit
     * of the square of the last digit of the input parameter
     */
    public static void getLastDigitOfSquare() {
        long number = getUserInput();
        int lastDigit = getLastDigitOfNumber(number);
        int lastDigitOfSquare = (int) (Math.pow(lastDigit, 2) % 10);
        System.out.println("The last digit of the square of the input number is "+ lastDigitOfSquare);
    }

    /**
     * This method is used for calculation of the last digit of the input number
     * @param userInput the integer number received from console
     * @return lastDigit the last digit of the input number
     */
    public static int getLastDigitOfNumber(long userInput){
        int lastDigit = (int) (userInput % 10);
        return lastDigit;
    }

    /**
     *This method is used for receiving input parameter from console
     * @return number long value of number from console
     */
    public static long getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer number:");
        while (!scanner.hasNextLong()){
            System.out.println("Enter an integer number!");
            scanner.next();
        }
        long number = scanner.nextLong();
        return number;
    }
}
