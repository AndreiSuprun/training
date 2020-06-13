package test.suprun.styleoop.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.suprun.styleoop.entity.Point;
import com.suprun.styleoop.exception.ValidationException;
import com.suprun.styleoop.service.ShapeService;

import static org.testng.Assert.*;

public class ShapeServiceTest {

    ShapeService shapeService;

    @BeforeClass
    public void beforeClass() {
        shapeService = new ShapeService();
    }

    @DataProvider
    public static Object[][] inscribedSquareAreaPositive(){
        return new Object[][] {{4, 2}, {16, 8}, {25, 12.5}, {50, 25}};
    }

    @Test(dataProvider = "inscribedSquareAreaPositive")
    public void testCalculateInscribedSquareAreaPositive(double describedArea, double expectedResult) {
        try {
            double actual = shapeService.calculateInscribedSquareArea(describedArea);
            assertEquals(expectedResult, actual, 0.0001);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] inscribedSquareAreaNegative(){
        return new Object[][] {{4, 3}, {16, 10}, {25, 10}, {50, 10}};
    }

    @Test(dataProvider = "inscribedSquareAreaNegative")
    public void testCalculateInscribedSquareAreaNegative(double describedArea, double expectedResult) {
        try {
            double actual = shapeService.calculateInscribedSquareArea(describedArea);
            assertNotEquals(expectedResult, actual, 0.0001);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testCalculateInscribedSquareAreaException() throws ValidationException {
        shapeService.calculateInscribedSquareArea(-20);
    }

    @Test
    public void testCalculateSquareAreaRatioPositive() {
        try {
            double actual = shapeService.calculateSquareAreaRatio(10);
            assertEquals(2.0, actual, 0.0001);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test
    public void testCalculateSquareAreaRatioNegative() {
        try {
            double actual = shapeService.calculateSquareAreaRatio(10);
            assertNotEquals(1.0, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] circleCircumferencePositive(){
        return new Object[][] {{10, 62.8319}, {50, 314.1593}, {75.5, 474.3805}};
    }

    @Test(dataProvider = "circleCircumferencePositive")
    public void testCalculateCircleCircumferencePositive(double input, double expectedResult) {
        try {
            double actual = shapeService.calculateCircleCircumference(input);
            assertEquals(expectedResult, actual, 0.0001);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

        @DataProvider
        public static Object[][] circleCircumferenceNegative(){
            return new Object[][] {{10, 12.8319}, {50, 375.1593}, {75.5, 576.3805}};
        }

        @Test(dataProvider = "circleCircumferenceNegative")
        public void testCalculateCircleCircumferenceNegative(double input, double expectedResult) {
            try {
                double actual = shapeService.calculateCircleCircumference(input);
                assertNotEquals(expectedResult, actual, 0.0001);
            } catch (ValidationException e) {
                fail("Exception was thrown");
            }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testCalculateCircleCircumferenceException() throws ValidationException {
        shapeService.calculateCircleCircumference(-20);
    }
    @DataProvider
    public static Object[][] circleAreaPositive(){
        return new Object[][] {{10, 314.1593}, {50, 7853.9816}, {75.5, 17907.8635}};
    }

    @Test(dataProvider = "circleAreaPositive")
    public void testCalculateCircleAreaPositive(double input, double expectedResult) {
        try {
            double actual = shapeService.calculateCircleArea(input);
            assertEquals(expectedResult, actual, 0.0001);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] circleAreaNegative(){
        return new Object[][] {{10, 300.8319}, {50, 7853.1593}, {75.5, 19789.3805}};
    }

    @Test(dataProvider = "circleAreaNegative")
    public void testCalculateCircleAreaNegative(double input, double expectedResult) {
        try {
            double actual = shapeService.calculateCircleArea(input);
            assertNotEquals(expectedResult, actual, 0.0001);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testCalculateCircleAreaException() throws ValidationException {
        shapeService.calculateCircleArea(-15);
    }

    @DataProvider
    public static Object[][] nearestPointPositive(){
        return new Object[][] {{new Point(1, 1),  new Point(2, 2), new Point(1, 1)},
                {new Point(2, 3),  new Point(2, 2), new Point(2, 2)}};
    }

    @Test(dataProvider = "nearestPointPositive")
    public void testCalculateNearestToOriginPointPositive(Point point1, Point point2, Point expectedResult) {
        try {
            Point actual = shapeService.calculateNearestToOriginPoint(point1, point2);
            assertEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @DataProvider
    public static Object[][] nearestPointNegative(){
        return new Object[][] {{new Point(1, 1),  new Point(2, 2), new Point(2, 2)},
                {new Point(2, 3),  new Point(2, 2), new Point(2, 3)}};
    }

    @Test(dataProvider = "nearestPointNegative")
    public void testCalculateNearestToOriginPointNegative(Point point1, Point point2, Point expectedResult) {
        try {
            Point actual = shapeService.calculateNearestToOriginPoint(point1, point2);
            assertNotEquals(expectedResult, actual);
        } catch (ValidationException e) {
            fail("Exception was thrown");
        }
    }

    @Test(expectedExceptions = ValidationException.class)
    public void testCalculateNearestToOriginPointException() throws ValidationException {
        shapeService.calculateNearestToOriginPoint(new Point(1,1), null);
    }

    @AfterClass
    public void afterClass() {
        shapeService = null;
    }
}