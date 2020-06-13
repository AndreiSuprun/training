package test.suprun.styleoop.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.suprun.styleoop.exception.ValidationException;
import com.suprun.styleoop.service.ArithmeticService;
import java.util.TreeMap;
import java.util.Map;

import static org.testng.Assert.*;

public class ArithmeticServiceTest {

    ArithmeticService arithmeticService;

    @BeforeClass
    public void beforeClass() {
        arithmeticService = new ArithmeticService();
    }

    @DataProvider
    public static Object[][] lastDigitSquarePositive(){
        return new Object[][] {{0, 0}, {234, 6}, {56565, 5}, {-4543, 9}};
    }

    @Test(dataProvider = "lastDigitSquarePositive")
    public void testCalculateLastDigitOfSquarePositive(long inputNumber, int expectedResult) {
        int actual = arithmeticService.calculateLastDigitOfSquare(inputNumber);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] lastDigitSquareNegative(){
        return new Object[][] {{0, 3}, {234, 2}, {56565, 7}, {-4543, 4}};
    }

    @Test(dataProvider = "lastDigitSquareNegative")
    public void testCalculateLastDigitOfSquareNegative(long inputNumber, int expectedResult) {
        int actual = arithmeticService.calculateLastDigitOfSquare(inputNumber);
        assertNotEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] evenNumbers(){
        return new Object[][] {{new int[]{0, 60, 6, 10}, true}, {new int[]{122, 4, 3, 8}, true}, {new int[]{122, 1, 3, 8}, true},
                {new int[]{122, 1, 3, 7}, false}, {new int[]{119, 1, 3, 1}, false}};
    }

    @Test(dataProvider = "evenNumbers")
    public void testIsEvenNumbersPresent(int[] evenNumbers, boolean expectedResult) {
        try {
            boolean actual = arithmeticService.isEvenNumbersPresent(evenNumbers);
            assertEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] evenNumbersException(){
        return new Object[][] {{0, 60, 6}, {122, 4}, {122, 1, 3, 8, 23},
                {122, 1, 3, 7, 5, 76}};
    }

    @Test(dataProvider = "evenNumbersException", expectedExceptions = ValidationException.class)
    public void testIsEvenNumbersPresentException(int[] numbers) throws ValidationException {
        arithmeticService.isEvenNumbersPresent(numbers);
    }

    @DataProvider
    public static Object[][] perfectNumbers(){
        return new Object[][] {{2, false}, {6, true}, {28, true}, {33,false}};
    }

    @Test(dataProvider = "perfectNumbers")
    public void testIsPerfectNumber(long perfectNumber, boolean expectedResult) {
        try {
            boolean actual = arithmeticService.isPerfectNumber(perfectNumber);
            assertEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testIsPerfectNumberException() throws ValidationException {
        arithmeticService.isPerfectNumber(-10L);
    }

    @DataProvider
    public static Object[][] functionsInputPositive(){
        return new Object[][] {{5, 19}, {2, 0.5}, {6, 27},
                {-10, -9.940357E-4}, {2547, 6479577}};
    }

    @Test(dataProvider = "functionsInputPositive")
     public void testCalculateFunctionValuePositive(double inputNumber, double expectedResult) {
        double actual = arithmeticService.calculateFunctionValue(inputNumber);
        assertEquals(expectedResult, actual, 0.0001);
    }

    @DataProvider
    public static Object[][] functionsInputNegative(){
        return new Object[][] {{5, 2}, {2, 78.5}, {6, 45},
                {-10, -9.1}, {2547, 647951}};
    }

    @Test(dataProvider = "functionsInputNegative")
    public void testCalculateFunctionValueNegative(double inputNumber, double expectedResult) {
        double actual = arithmeticService.calculateFunctionValue(inputNumber);
        assertNotEquals(expectedResult, actual, 0.0001);
    }

    @DataProvider
    public static Object[][] functionsTangentPositive(){
        Map<Double, Double> map1 = new TreeMap<>();
        map1.put(10.0, 0.64836);
        map1.put(12.0, -0.63586);
        map1.put(14.0, 7.24461);
        map1.put(16.0, 0.30063);
        map1.put(18.0, -1.13731);
        map1.put(20.0, 2.23716);
        Map<Double, Double> map2 = new TreeMap<>();
        map2.put(-10.0, -0.64836);
        map2.put(0.0, 0.0);
        map2.put(10.0, 0.64836);
        map2.put(20.0, 2.23716);
        map2.put(30.0, -6.40533);
        map2.put(40.0, -1.11721);
        return new Object[][] {{10.0, 20.0, 2.0, map1}, {-10.0, 40.0, 10.0, map2}};
    }

    @Test(dataProvider = "functionsTangentPositive")
    public void testCalculateTangentFunctionPositive(double startRange, double endRange,
                                             double step, TreeMap<Double, Double> map) {
        for (double i = startRange; i<= endRange; i+=step){
            double value = Math.tan(i);
            assertEquals((double)map.get(i), value, 0.001);
        }
    }

    @DataProvider
    public static Object[][] functionsTangentNegative(){
        Map<Double, Double> map1 = new TreeMap<>();
        map1.put(10.0, 1.64836);
        map1.put(12.0, -1.63586);
        map1.put(14.0, 3.24461);
        map1.put(16.0, 4.30063);
        map1.put(18.0, -3.13731);
        map1.put(20.0, 6.23716);
        Map<Double, Double> map2 = new TreeMap<>();
        map2.put(-10.0, -1.64836);
        map2.put(0.0, 3.0);
        map2.put(10.0, 3.64836);
        map2.put(20.0, 5.23716);
        map2.put(30.0, -2.40533);
        map2.put(40.0, -7.11721);
        return new Object[][] {{10.0, 20.0, 2.0, map1}, {-10.0, 40.0, 10.0, map2}};
    }

    @Test(dataProvider = "functionsTangentNegative")
    public void testCalculateTangentFunctionNegative(double startRange, double endRange,
                                             double step, TreeMap<Double, Double> map) {
        for (double i = startRange; i<= endRange; i+=step){
            double value = Math.tan(i);
            assertNotEquals((double)map.get(i), value, 0.001);
        }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testCalculateTangentFunctionException() throws ValidationException {
        arithmeticService.calculateTangentFunction(10, 0, 2);
    }

    @AfterClass
    public void afterClass() {
        arithmeticService = null;
    }
}