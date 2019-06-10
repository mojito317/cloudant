package apps;

import documents.AirportDocument;
import documents.Point;
import services.AirportService;
import services.CalculatorService;

import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;

import static java.text.MessageFormat.format;

public class AirportsApp {
    private AirportService airportService;

    public AirportsApp(AirportService airportService) {
        this.airportService = airportService;
    }

    public void run(String[] args) {
        try {
            double radius = Double.parseDouble(args[0]);
            Point center = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));

            Properties prop = new Properties();
            prop.setProperty("db.username", "mikerhodes");
            prop.setProperty("db.name", "airportdb");
            prop.setProperty("db.search", "view1/geo");

            Predicate<AirportDocument> predicate =
                    p -> CalculatorService.getDistanceFromCenterToAirport(center, p) <= radius;


            List<AirportDocument> results = airportService.filterAndSort(radius, center, predicate, prop);

            for (int i = 0; i < results.size(); i++) {
                AirportDocument result = results.get(i);
                System.out.println(format("{0}. {1}, distance is {2} from {3} lat and {4} lon.",
                        i, result.getName(), CalculatorService.getDistanceFromCenterToAirport(center, result),
                        center.getLat(), center.getLon()));
            }

        } catch (NumberFormatException e) {
            System.out.println("All of three arguments must be double numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There must be three double numbers in the arguments.");
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try to run the application again.");
        }
    }

}
