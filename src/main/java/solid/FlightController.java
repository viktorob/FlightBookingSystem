package solid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FlightController {
    private List<Flight> flights;

    /**
    public Flight searchFlight(String flightNumber) {
        // leitar eftir flightNumber
    }
     */

    public FlightController() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchFlights(String flightNumber, String srcAirport, String destAirport,
                                      Date departureTime, Date arrivalTime, Double maxPrice) {
        return flights.stream()
                .filter(f -> (flightNumber == null || f.getFlightNumber().equalsIgnoreCase(flightNumber)))
                .filter(f -> (srcAirport == null || f.getSrcAirport().equalsIgnoreCase(srcAirport)))
                .filter(f -> (destAirport == null || f.getDestAirport().equalsIgnoreCase(destAirport)))
                .filter(f -> (departureTime == null || f.getDepartureTime().equals(departureTime)))
                .filter(f -> (arrivalTime == null || f.getArrivalTime().equals(arrivalTime)))
                .filter(f -> (maxPrice == null || f.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }

    public List<Flight> sortFlightsByPrice() {
        return flights.stream()
                .sorted(Comparator.comparingDouble(Flight::getPrice))
                .collect(Collectors.toList());
    }


    public List<Flight> sortFlightsByDepartureTime() {
        return flights.stream()
                .sorted(Comparator.comparing(Flight::getDepartureTime))
                .collect(Collectors.toList());
    }

    public List<Flight> filterByAirline(String airline) {
        return flights.stream()
                .filter(f -> f.getAirline().equalsIgnoreCase(airline))
                .collect(Collectors.toList());
    }

}
