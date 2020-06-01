package suprun.andrei.styleoop.task4;

import java.util.Scanner;

public class PresenceOfEvenNumbers {

    public static long[] getUserInput() {
        long[] num = new long[4];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer number A:");
        num[0] = getInputNumber(scanner);
        System.out.println("Enter integer number B:");
        num[1] = getInputNumber(scanner);
        System.out.println("Enter integer number C:");
        num[2] = getInputNumber(scanner);
        System.out.println("Enter integer number D:");
        num[3] = getInputNumber(scanner);
        return num;
    }

    public static void isEvenNumbersPresent(){
        long[] numbers = getUserInput();
        int x = 0;
        for (int i=0; i<=3; i++){
            if (numbers[i]%2==0) {
                x++;
            }
        }
        System.out.println(x >= 2);
    }

    public static long getInputNumber(Scanner scanner){
        while (!scanner.hasNextLong()){
            System.out.println("Invalid input! Enter integer number:");
            scanner.next();
        }
        long number = scanner.nextLong();
        return number;
    }
}
