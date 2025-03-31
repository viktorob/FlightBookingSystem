import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solid.Flight;
import solid.FlightController;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;;

class FlightControllerTest {

    private FlightController flightController;
    private Flight flight1, flight2, flight3;

    @BeforeEach
    void setUp() {
        flightController = new FlightController();

        // Creating actual Flight objects
        flight1 = new Flight("AA123", "Icelandair", "Boeing 737",
                "KEF", "LAX", new Date(1700000000000L), new Date(1700003600000L),
                150, 350.00, 200.5f);

        flight2 = new Flight("BA456", "British Airways", "Airbus A320",
                "LHR", "JFK", new Date(1800000000000L), new Date(1800003600000L),
                180, 500.00, 220.0f);

        flight3 = new Flight("DL789", "Delta Airlines", "Boeing 777",
                "ATL", "LAX", new Date(1750000000000L), new Date(1750003600000L),
                200, 400.00, 250.0f);

        // Adding flights to controller
        flightController.addFlight(flight1);
        flightController.addFlight(flight2);
        flightController.addFlight(flight3);
    }

    @Test
    void testSearchFlightByNumber() {
        List<Flight> result = flightController.searchFlights("AA123", null, null, null, null, null);
        assertEquals(1, result.size());
        assertEquals("AA123", result.get(0).getFlightNumber());
    }

    @Test
    void testSearchFlightByAirports() {
        List<Flight> result = flightController.searchFlights(null, "JFK", "LAX", null, null, null);
        assertEquals(1, result.size());
        assertEquals("JFK", result.get(0).getSrcAirport());
        assertEquals("LAX", result.get(0).getDestAirport());
    }

    @Test
    void testSortFlightsByPrice() {
        List<Flight> sortedFlights = flightController.sortFlightsByPrice();
        assertEquals(flight1, sortedFlights.get(0)); // Cheapest first
        assertEquals(flight3, sortedFlights.get(1));
        assertEquals(flight2, sortedFlights.get(2)); // Most expensive last
    }

    @Test
    void testSortFlightsByDepartureTime() {
        List<Flight> sortedFlights = flightController.sortFlightsByDepartureTime();
        assertEquals(flight1, sortedFlights.get(0)); // Earliest flight first
        assertEquals(flight3, sortedFlights.get(1));
        assertEquals(flight2, sortedFlights.get(2)); // Latest flight last
    }

    @Test
    void testFilterByAirline() {
        List<Flight> result = flightController.filterByAirline("Delta Airlines");
        assertEquals(1, result.size());
        assertEquals("DL789", result.get(0).getFlightNumber());
    }
}
