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
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AirportService {

    public List<AirportDocument> filterAndSort(Double radius, Point center, Predicate<AirportDocument> predicate,
                                               Properties properties) {
        List<AirportDocument> airportDocuments = getAirportSearch(radius, center, properties);
        return airportDocuments.stream()
                .filter(p -> predicate.test(p))
                .sorted(new DistanceComparator(center))
                .collect(Collectors.toList());
    }

    private List<AirportDocument> getAirportSearch(Double radius, Point center, Properties properties) {
        CloudantClient client = ClientBuilder.account(properties.getProperty("db.username")).build();
        Database db = client.database(properties.getProperty("db.name"), false);
        Search search = db.search(properties.getProperty("db.search"));
        AirportDbClient airportDbClient = new AirportDbClient(search);

        List<AirportDocument> airportDocuments = airportDbClient.getAirPortsByLongitudeAndLatitude(
                center.getLon() - radius, center.getLon() + radius,
                center.getLat() - radius, center.getLat() + radius);

        return airportDocuments;
    }
}
