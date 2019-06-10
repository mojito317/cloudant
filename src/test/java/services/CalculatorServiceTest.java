package services;

import documents.AirportDocument;
import documents.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void getDistanceFromCenterToAirport() {
        AirportDocument airportDocument = new AirportDocument(0.0, 0.0, "Michigan");
        Point point = new Point(0.0, 0.0);
        assertEquals(0.0, CalculatorService.getDistanceFromCenterToAirport(point, airportDocument), 0.0);
    }

    @Test
    public void getDistanceFromCenterToAirportHamburg() {
        AirportDocument airportDocument = new AirportDocument(53.630389, 9.988228, "Hamburg");
        Point point = new Point(53.630389, 9.988228);
        assertEquals(0.0, CalculatorService.getDistanceFromCenterToAirport(point, airportDocument), 0.0);
    }
}