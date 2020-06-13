package test.suprun.styleoop.validator;

import org.testng.annotations.*;
import com.suprun.styleoop.validator.DataValidator;

import static org.testng.Assert.*;

public class DataValidatorTest {

    DataValidator validator;

    @BeforeClass
    public void beforeClass() {
        validator = new DataValidator();
    }

    @DataProvider
    public static Object[][] monthNumbers(){
        return new Object[][] {{0, false}, {1, true}, {12, true}, {13,false}};
    }

    @Test(dataProvider = "monthNumbers")
    public void testValidateMonthNumber(int monthNumber, boolean expectedResult) {
        boolean actualResult = validator.validateMonthNumber(monthNumber);
        assertEquals(expectedResult, actualResult);
    }   

    @DataProvider
    public static Object[][] yearNumbers(){
        return new Object[][] {{0, false}, {1581, false}, {1582, true}, {2200,true}};
    }

    @Test(dataProvider = "yearNumbers")
    public void testValidateYearNumber(int yearNumber, boolean expectedResult) {
        boolean actualResult = validator.validateYearNumber(yearNumber);
        assertEquals(expectedResult, actualResult);
    }

    @DataProvider
    public static Object[][] secondsNumbers(){
        return new Object[][] {{-12, false}, {0, true}, {86399, true}, {86401,false}};
    }

    @Test(dataProvider = "secondsNumbers")
    public void testValidateNumberOfSecondsInDay(int secondsNumber, boolean expectedResult) {
        boolean actualResult = validator.validateNumberOfSecondsInDay(secondsNumber);
        assertEquals(expectedResult, actualResult);
    }

    @DataProvider
    public static Object[][] tangentFunctionInput(){
        return new Object[][] {{0, 60, 5, true}, {60, 0, 5, false}, {0, 60, -5, false},
                {0, 0, 0, false}, {0, 60, 0, false}};
    }

    @Test(dataProvider = "tangentFunctionInput")
    public void testValidateTangentFunctionInput(double startRange, double endRange,
                                                 double step, boolean expectedResult) {
        boolean actualResult = validator.validateTangentFunctionInput(startRange, endRange, step);
        assertEquals(expectedResult, actualResult);
    }

    @AfterClass
    public void afterClass() {
        validator = null;
    }
}