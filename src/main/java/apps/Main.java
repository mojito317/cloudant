import apps.AirportsApp;
import services.AirportService;

public class Main {
    public static void main(String[] args) {
        AirportsApp app = new AirportsApp(new AirportService());
        app.run(args);
    }
}
