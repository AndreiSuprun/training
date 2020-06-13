package com.suprun.styleoop.validator;

// class is used for validation of different input parameters
public class DataValidator {

    public static final int START_LEAP_YEAR = 1582;
    public static final int SECONDS_IN_DAY = 86400;

    // method validates month number in range from 1 to 12
    public boolean validateMonthNumber(int monthNumber){
        return monthNumber>=1 && monthNumber<=12;
    }

    // method validates year number which must start from 1582
    public boolean validateYearNumber(int yearNumber){
        return yearNumber >= START_LEAP_YEAR;
    }

    // method validates month number in range from 0 to 86400
    public boolean validateNumberOfSecondsInDay(int secondsNumber){
        return secondsNumber >= 0 && secondsNumber < SECONDS_IN_DAY;
    }

    // method validates calculate range and step of tangent function
    public boolean validateTangentFunctionInput(double startRange, double endRange, double step){
        return startRange < endRange && step > 0;
    }

}
