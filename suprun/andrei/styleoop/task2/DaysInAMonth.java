package suprun.andrei.styleoop.task2;

import java.util.Scanner;

/**
 * This class is used for calculation the number of days in the specified month of the specified year
 */
public class DaysInAMonth {

    /**
     *Thi s method is used for calculation and displaying the number of days
     * in the specified month of the specified year
     */
    public static void getNumberOfDaysInAMonth(){
        int year = getYear();
        int numberOfAMonth = getNumberOfAMonth();
        switch (numberOfAMonth){
            case 2: {
                System.out.println(isLeapYear(year) ? "29 days" : "28 days");
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                System.out.println("30 days");
                break;
            }
            default:{
                System.out.println("31 days");
                break;
            }
        }
    }

    /**
     * This method is used for receiving the year from console
     * @return year the integer value of the year from console
     */
    public static int getYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year:");
        while (!scanner.hasNextInt()) {
            System.out.println("Enter an integer number!");
            scanner.next();
        }
        int year = scanner.nextInt();
        return year;
    }

    /**
     * This method is used for receiving the number of the month from console
     * @return numberOfAMonth the integer value of the number of the month from console
     */
    public static int getNumberOfAMonth(){
        Scanner scanner = new Scanner(System.in);
        int numberOfAMonth;
        do {
            System.out.println("Enter a number of a month from 1 to 12:");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid Input! Enter an integer number from 1 to 12:");
                scanner.next();
            }
            numberOfAMonth = scanner.nextInt();
        } while (numberOfAMonth < 1 ||  numberOfAMonth > 12);
        return numberOfAMonth;
    }

    /**
     * This method is used for determining if the given year is leap
     * The year is a leap year if it is divisible by four without remainder
     * But years divisible by 100 is not leap with the exception of years divisible by 400
     * @param year the integer value of the year from console
     * @return the boolean value which is true when the year is leap and is false otherwise
     */
    public static boolean isLeapYear(int year){
        return ((year&3)==0 && ((year % 100)!=0 || (year % 400)==0));
    }
}
