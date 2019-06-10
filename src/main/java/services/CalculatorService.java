package services;

import documents.AirportDocument;
import documents.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CalculatorService {
    public static double getDistanceFromCenterToAirport(Point center, AirportDocument airport) {
        return sqrt(pow(airport.getLat() - center.getLat(), 2) +
                pow(airport.getLon() - center.getLon(), 2));
    }
}
