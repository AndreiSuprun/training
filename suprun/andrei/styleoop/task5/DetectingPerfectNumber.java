package suprun.andrei.styleoop.task5;

import java.util.Scanner;

/**
 * This class is used for determination if the input number is perfect
 */
public class DetectingPerfectNumber {

    /**
     * This method is used for calculation and displaying boolean value
     * which depends on perfection of the input number.
     * If the number is perfect the method returns true, otherwise false
     */
    public static void isPerfectNumber(){
        long inputNumber = getInputNumber();
        long sum = 1;
        for (long x=2; x<=inputNumber/2; x++)
            if (inputNumber % x == 0) {
                sum += x;
            }
        System.out.println(sum==inputNumber);
    }

    /**
     *This method is used for receiving input parameter from console
     * @return inputNumber long value of number which perfection is needed to determine
     */
    public static long getInputNumber(){
        Scanner scanner = new Scanner(System.in);
        long inputNumber;
        do {
            System.out.println("Enter a positive integer number:");
            while (!scanner.hasNextLong()) {
                System.out.println("Invalid Input! Enter a positive integer number:");
                scanner.next();
            }
            inputNumber = scanner.nextLong();
        } while (inputNumber <= 0);
        return inputNumber;
    }
}
