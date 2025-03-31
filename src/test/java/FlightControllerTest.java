import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import solid.Flight;
import solid.FlightController;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;;

class FlightControllerTest {

    private FlightController flightController;
    private Flight flight1, flight2, flight3;

    @BeforeEach
    void setUp() {
        flightController = new FlightController();


        // Mock Flight objects
        flight1 = new Flight("IA123", "Icelandair", "Boeing 737",
                "KEF", "LAX",
                LocalDateTime.of(2025, 4, 15, 10, 30),  // April 15, 2025, 10:30 AM
                LocalDateTime.of(2025, 4, 15, 14, 45),
                150, 350.00, 200.5f);

        flight2 = new Flight("BA456", "British Airways", "Airbus A320",
                "LHR", "JFK",
                LocalDateTime.of(2025, 7, 22, 8, 15),  // July 22, 2025, 8:15 AM
                LocalDateTime.of(2025, 7, 22, 11, 50), // July 22, 2025, 11:50 AM,
                180, 500.00, 220.0f);

        flight3 = new Flight("DL789", "Delta Airlines", "Boeing 777",
                "ATL", "LAX",
                LocalDateTime.of(2025, 12, 5, 18, 0),  // December 5, 2025, 6:00 PM
                LocalDateTime.of(2025, 12, 5, 21, 30), // December 5, 2025, 9:30 PM
                200, 400.00, 250.0f);


        // Add flights to controller
        flightController.addFlight(flight1);
        flightController.addFlight(flight2);
        flightController.addFlight(flight3);
    }

    @Test
    void testSearchFlightByNumber() {
        List<Flight> result = flightController.searchFlights("IA123", null, null, null, null, null);
        assertEquals(1, result.size());
        assertEquals("IA123", result.getFirst().getFlightNumber());
    }

    @Test
    void testSearchFlightByAirports() {
        List<Flight> result = flightController.searchFlights(null, "KEF", "LAX", null, null, null);
        assertEquals(1, result.size());
        assertEquals("KEF", result.getFirst().getSrcAirport());
        assertEquals("LAX", result.getFirst().getDestAirport());
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
        assertEquals(flight2, sortedFlights.get(1));
        assertEquals(flight3, sortedFlights.get(2)); // Latest flight last
    }

    @Test
    void testFilterByAirline() {
        List<Flight> result = flightController.filterByAirline("Delta Airlines");
        assertEquals(1, result.size());
        assertEquals("DL789", result.getFirst().getFlightNumber());
    }
}
