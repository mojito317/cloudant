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

    @Test
    public void getCeilOfDecimal() {
        assertEquals(CalculatorService.getCeilOfDecimal(3.416), 3.5, 0.0);
        assertEquals(CalculatorService.getCeilOfDecimal(1233.8716), 1233.9, 0.0);
    }

    @Test
    public void getFloorOfDecimal() {
        assertEquals(CalculatorService.getFloorOfDecimal(3.416), 3.4, 0.0);
        assertEquals(CalculatorService.getFloorOfDecimal(1233.8716), 1233.8, 0.0);
    }
}