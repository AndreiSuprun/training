package com.suprun.styleoop.service;

import com.suprun.styleoop.entity.Point;
import com.suprun.styleoop.exception.ValidationException;

// class is used for calculation different shapes features
public class ShapeService {

    // method calculates inscribed square area
    public double calculateInscribedSquareArea(double describedSquareArea) throws ValidationException {
        if (describedSquareArea < 0){
            throw new ValidationException("Square area must be positive");
        }
        double describedSquareSide = Math.sqrt(describedSquareArea);
        double inscribedSquareArea = Math.pow(Math.sqrt(describedSquareArea), 2) / 2;
        return inscribedSquareArea;
    }

    // method calculates square area ratio
    public double calculateSquareAreaRatio(double describedSquareArea) throws ValidationException {
        double inscribedSquareArea = this.calculateInscribedSquareArea(describedSquareArea);
        double squareAreaRatio = describedSquareArea / inscribedSquareArea;
        return squareAreaRatio;
    }

    // method calculates circle circumference
    public double calculateCircleCircumference(double radius) throws ValidationException {
        if (radius < 0){
            throw new ValidationException("Radius must be positive");
        }
        double circumference = 2 * Math.PI * radius;
        return circumference;
    }

    // method calculates circle area
    public double calculateCircleArea(double radius) throws ValidationException {
        if (radius < 0){
            throw new ValidationException("Radius must be positive");
        }
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    // method calculates which of two points is nearest to origin point
    public Point calculateNearestToOriginPoint(Point point1, Point point2) throws ValidationException {
        if (point1 == null || point2 == null){
            throw new ValidationException("Point must not be null");
        }
        double distanceFromPoint1ToOrigin = Math.hypot(point1.getX(), point1.getY());
        double distanceFromPoint2ToOrigin = Math.hypot(point2.getX(), point2.getY());
        if (distanceFromPoint1ToOrigin < distanceFromPoint2ToOrigin) {
            return point1;
        } else {
            return point2;
        }
    }
}
