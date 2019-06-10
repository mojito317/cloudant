package apps;

import documents.AirportDocument;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.AirportService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class AirportsAppTest {

    private AirportsApp app;

    @Mock
    private AirportService airportService;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        app = new AirportsApp(airportService);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void runWithSuccess() {
        List<AirportDocument> documents = new
                ArrayList<>();
        documents.add(new AirportDocument(3.0, 2.0, "Michigan"));
        when(airportService.filterAndSort(any(), any(), any(), any())).thenReturn(documents);

        String command = "1 3.0 2.0";
        String[] args = command.split(" ");
        app.run(args);
        assertThat(outContent.toString(), containsString("0. Michigan, distance is 0"));
    }

    @Test
    public void runStringsAreInTheCommandLineShouldFail() {
        String command = "1 three 2.0";
        String[] args = command.split(" ");
        app.run(args);
        assertThat(outContent.toString(), containsString("All of three arguments must be double numbers."));
    }

    @Test
    public void runLessArgumentsInTheCommandLineShouldFail() {
        String command = "1 2";
        String[] args = command.split(" ");
        app.run(args);
        assertThat(outContent.toString(), containsString("There must be three double numbers in the arguments."));
    }

    @Test
    public void runExceptionOccur() {
        String command = "1 2 3";
        String[] args = command.split(" ");
        when(airportService.filterAndSort(any(), any(), any(), any())).thenThrow(new RuntimeException());
        app.run(args);

        assertThat(outContent.toString(), containsString("Something went wrong. Please try to run the application again."));
    }

}