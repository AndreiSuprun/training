package test.suprun.styleoop.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.suprun.styleoop.exception.ValidationException;
import com.suprun.styleoop.service.DateService;

import static org.testng.Assert.*;

public class DateServiceTest {

    DateService dateService;

    @BeforeClass
    public void beforeClass() {
        dateService = new DateService();
    }

    @DataProvider
    public static Object[][] monthNumberPositive(){
        return new Object[][] {{2020, 2, 29}, {1582, 2, 28}, {1992, 1, 31}, {1900, 4, 30}};
    }

    @Test(dataProvider = "monthNumberPositive")
    public void testCalculateDaysNumberInMonthPositive(int year, int monthNumber, int expectedResult) {
        try {
            int actual = dateService.calculateDaysNumberInMonth(year, monthNumber);
            assertEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] monthNumberNegative(){
        return new Object[][] {{2020, 2, 28}, {1582, 2, 30}, {1992, 1, 30}, {1900, 4, 31}};
    }

    @Test(dataProvider = "monthNumberNegative")
    public void testCalculateDaysNumberInMonthNegative(int year, int monthNumber, int expectedResult) {
        try {
            int actual = dateService.calculateDaysNumberInMonth(year, monthNumber);
            assertNotEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Year must be more than 1582", expectedExceptions = ValidationException.class)
    public void testCalculateDaysNumberInMonthExceptionYear() throws ValidationException {
        dateService.calculateDaysNumberInMonth(1500, 1);
    }

    @Test(expectedExceptionsMessageRegExp = "Month number must be in range from 1 to 12", expectedExceptions = ValidationException.class)
    public void testCalculateDaysNumberInMonthExceptionMonth() throws ValidationException {
        dateService.calculateDaysNumberInMonth(1900, 14);
    }

    @DataProvider
    public static Object[][] years(){
        return new Object[][] {{2020, true}, {1900, false}, {2004, true}, {2001, false}};
    }

    @Test(dataProvider = "years")
    public void testIsLeapYear(int year, boolean expectedResult) {
        boolean actual = dateService.isLeapYear(year);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] secondsTimePositive(){
        return new Object[][] {{12222, new int[]{3, 23, 42}}, {47813, new int[]{13, 16, 53}}};
    }

    @Test(dataProvider = "secondsTimePositive")
    public void testTimeInHoursMinutesSecondsPositive(int seconds, int[] expectedResult) {
        try {
            int[] actual = dateService.timeInHoursMinutesSeconds(seconds);
            assertEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] secondsTimeNegative(){
        return new Object[][] {{12222, new int[]{1, 47, 15}}, {47813, new int[]{12, 5, 19}}};
    }

    @Test(dataProvider = "secondsTimeNegative")
    public void testTimeInHoursMinutesSecondsNegative(int seconds, int[] expectedResult) {
        try {
            int[] actual = dateService.timeInHoursMinutesSeconds(seconds);
            assertNotEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testTimeInHoursMinutesSecondsException() throws ValidationException {
        dateService.timeInHoursMinutesSeconds(90000);
    }

    @AfterClass
    public void afterClass() {
        dateService = null;
    }
}