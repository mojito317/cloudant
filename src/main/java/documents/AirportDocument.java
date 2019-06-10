package documents;

public class AirportDocument {
    private Double lat;
    private Double lon;
    private String name;

    public AirportDocument(Double lat, Double lon, String name) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "{\n\tlat: " + lat + "\n\tlon: " + lon + "\n\tname: " + name + "\n}";
    }
}
