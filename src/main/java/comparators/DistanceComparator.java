package comparators;

import documents.AirportDocument;
import documents.Point;
import services.CalculatorService;

import java.util.Comparator;

public class DistanceComparator implements Comparator<AirportDocument> {

    private Point center;

    public DistanceComparator(Point center) {
        this.center = center;
    }

    @Override
    public int compare(AirportDocument airport1, AirportDocument airport2) {
        double d1 = CalculatorService.getDistanceFromCenterToAirport(center, airport1);
        double d2 = CalculatorService.getDistanceFromCenterToAirport(center, airport2);
        if (d1 == d2) {
            return 0;
        }
        return d1 < d2 ? -1 : 1;
    }
}