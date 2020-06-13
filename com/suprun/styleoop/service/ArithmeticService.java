package com.suprun.styleoop.service;

import com.suprun.styleoop.exception.ValidationException;
import com.suprun.styleoop.validator.DataValidator;
import java.util.TreeMap;
import java.util.Map;

// class is used for calculation of different arithmetic features
public class ArithmeticService {

    // method calculates last square digit of number last digit
    public int calculateLastDigitOfSquare(long number) {
        int lastDigitOfSquare = (int) (Math.pow(number % 10, 2) % 10);
        return lastDigitOfSquare;
    }

    // method calculates if at least two even number are present among four
    public boolean isEvenNumbersPresent(int[] numbers) throws ValidationException {
        if (numbers.length != 4) {
            throw new ValidationException("Quantity of numbers must be 4");
        }
        int x = 0;
        for (int i = 0; i<numbers.length; i++){
            if (numbers[i]%2 == 0) {
                x++;
            }
        }
        return x >= 2;
    }

    // method calculates if specified number is perfect
    public boolean isPerfectNumber(long number) throws ValidationException {
        if (number < 0){
            throw new ValidationException("Number must be positive");
        }
        long sum = 1;
        for (long x = 2; x <= number / 2; x++)
            if (number % x == 0) {
                sum += x;
            }
        return sum == number;
    }

    // method calculates function value for specified input
    public double calculateFunctionValue(double input){
        double result;
        if (input >= 3){
            result = Math.pow(input, 2) - 3 * input + 9;
        } else {
            result = 1 / (Math.pow(input, 3) - 6);
        }
        return result;
    }

    // method calculates tangent function value for specified range and step
    public Map<Double, Double> calculateTangentFunction(double startRange, double endRange,
                                                            double step) throws ValidationException {
        DataValidator validator = new DataValidator();
        if (!validator.validateTangentFunctionInput(startRange, endRange, step)){
            throw new ValidationException("Initial value of range must be greater then end value of range " +
                    "and step must be positive");
        }
        Map<Double, Double> valueTable = new TreeMap<>();
        for (double i = startRange; i <= endRange; i += step){
            double value = Math.tan(i);
            valueTable.put(i, value);
        }
        return valueTable;
    }
}
