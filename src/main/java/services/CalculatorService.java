package services;

import documents.AirportDocument;
import documents.Point;

import static java.lang.Math.*;

public class CalculatorService {
    public static double getDistanceFromCenterToAirport(Point center, AirportDocument airport) {
        return sqrt(pow(airport.getLat() - center.getLat(), 2) +
                pow(airport.getLon() - center.getLon(), 2));
    }

    public static double getFloorOfDecimal(double num){
        return floor(num*10) / 10;
    }

    public static double getCeilOfDecimal(double num){
        return ceil(num*10) / 10;
    }
}
