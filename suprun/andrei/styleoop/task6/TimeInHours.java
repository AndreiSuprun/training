package suprun.andrei.styleoop.task6;

import java.util.Scanner;

/**
 * This class is used for representation of time given in seconds
 * from the beginning of the day in the form of full hours, minutes and seconds
 */
public class TimeInHours {

    /**
     * This method is used for calculating and displaying the time
     * in the form of full hours, minutes and seconds
     * */
    public static void timeInHours(){
        int timeInSeconds = getInputNumber();
        int hours = timeInSeconds/3600;
        int minutes = (timeInSeconds - hours*3600)/60;
        int seconds = timeInSeconds - minutes*60 - hours*3600;
        System.out.println(timeInSeconds+" seconds is "+hours+" hours "+minutes+" minutes "+seconds+" seconds");
    }

    /**
     * This method is used for receiving input parameter from console
     * @return seconds integer value of number of seconds received from console
     */
    public static int getInputNumber(){
        Scanner scanner = new Scanner(System.in);
        int seconds;
        do {
            System.out.println("Enter a positive integer number (a day consists of 86 400 seconds):");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid Input! Enter a positive integer number (a day consists of 86 400 seconds):");
                scanner.next();
            }
            seconds = scanner.nextInt();
        } while (seconds < 0 || seconds > 86400);
        return seconds;
    }

}
