package clients;

import com.cloudant.client.api.Search;
import com.cloudant.client.api.model.SearchResult;
import documents.AirportDocument;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class AirportDbClient {
    private final Search search;

    public AirportDbClient(Search search) {
        this.search = search;
    }

    public List<AirportDocument> getAirPortsByLongitudeAndLatitude(
            double lonMin, double lonMax, double latMin, double latMax) {
        List<SearchResult<AirportDocument>.SearchResultRow> searchResultRows =
                searchResultRows(lonMin, lonMax, latMin, latMax);

        return searchResultRows.stream()
                .map(SearchResult.SearchResultRow::getFields)
                .collect(Collectors.toList());
    }

    private List<SearchResult<AirportDocument>.SearchResultRow> searchResultRows(
            double lonMin, double lonMax, double latMin, double latMax) {

        String query = String.format(Locale.ENGLISH, "lon:[%.1f TO %.1f] AND lat:[%.1f TO %.1f]",
                lonMin, lonMax, latMin, latMax);
        return search
                .querySearchResult(query, AirportDocument.class).getRows();
    }
}
