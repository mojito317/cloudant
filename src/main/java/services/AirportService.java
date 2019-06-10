package services;

import clients.AirportDbClient;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.Search;
import comparators.DistanceComparator;
import documents.AirportDocument;
import documents.Point;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static services.CalculatorService.getCeilOfDecimal;
import static services.CalculatorService.getFloorOfDecimal;

public class AirportService {

    public List<AirportDocument> sort(Double radius, Point center,
                                      Properties properties) {
        List<AirportDocument> airportDocuments = getAirportSearch(radius, center, properties);
        return airportDocuments.stream()
                .sorted(new DistanceComparator(center))
                .collect(Collectors.toList());
    }

    private List<AirportDocument> getAirportSearch(Double radius, Point center, Properties properties) {
        CloudantClient client = ClientBuilder.account(properties.getProperty("db.username")).build();
        Database db = client.database(properties.getProperty("db.name"), false);
        Search search = db.search(properties.getProperty("db.search"));
        AirportDbClient airportDbClient = new AirportDbClient(search);

        List<AirportDocument> airportDocuments = airportDbClient.getAirPortsByLongitudeAndLatitude(
                getFloorOfDecimal(center.getLon() - radius), getCeilOfDecimal(center.getLon() + radius),
                getFloorOfDecimal(center.getLat() - radius), getCeilOfDecimal(center.getLat() + radius));

        return airportDocuments;
    }
}
