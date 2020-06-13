package com.suprun.styleoop.service;

import com.suprun.styleoop.exception.ValidationException;
import com.suprun.styleoop.validator.DataValidator;
import java.time.Month;

// class is used for calculation of different date features
public class DateService {

    public static final int SECONDS_IN_MINUTE = 60;
    public static final int SECONDS_IN_HOUR = 3600;

    // method calculates number od days in specified year and month
    public int calculateDaysNumberInMonth (int year, int monthNumber) throws ValidationException {
        DataValidator validator = new DataValidator();
        if (!validator.validateYearNumber(year)){
            throw new ValidationException("Year must be more than 1582");
        }
        if (!validator.validateMonthNumber(monthNumber)){
            throw new ValidationException("Month number must be in range from 1 to 12");
        }
        Month month = Month.of(monthNumber);
        int daysQuantity = month.length(this.isLeapYear(year));
        return daysQuantity;
    }

     /*
     method is used for determining if the given year is leap,
     the year is a leap year if it is divisible by four without remainder,
     but years divisible by 100 is not leap with the exception of years divisible by 400
     */
    public boolean isLeapYear(int year){
        return ((year&3)==0 && ((year % 100)!=0 || (year % 4000)==0));
    }

    // method calculates number of full hours, minutes and seconds in specified number of seconds
    public int[] timeInHoursMinutesSeconds(int timeInSeconds) throws ValidationException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.validateNumberOfSecondsInDay(timeInSeconds)){
            throw new ValidationException("Number of seconds must be in range from 0 to 86399");
        }
        int[] time = new int[3];
        time[0] = timeInSeconds / SECONDS_IN_HOUR; //hours
        time[1] = (timeInSeconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE; // minutes
        time[2] = timeInSeconds % SECONDS_IN_MINUTE; //seconds
        return time;
        }
}
