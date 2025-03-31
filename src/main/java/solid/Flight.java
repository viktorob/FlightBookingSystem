package solid;
import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private String airline;
    private String aircraftModel;
    private String srcAirport;
    private String destAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int availableSeats;
    private double price;
    private float co2Emissions;

    public Flight(String flightNumber, String airline, String aircraftModel, String srcAirport, String destAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int availableSeats, double price, float co2Emissions) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.aircraftModel = aircraftModel;
        this.srcAirport = srcAirport;
        this.destAirport = destAirport;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.availableSeats = availableSeats;
        this.price = price;
        this.co2Emissions = co2Emissions;
    }

    public Flight getFlightDetails() {
        return this;
    }

    // Getters
    public String getFlightNumber() { return this.flightNumber; }
    public String getAirline() { return this.airline; }
    public String getAircraftModel() { return this.aircraftModel; }
    public String getSrcAirport() { return this.srcAirport; }
    public String getDestAirport() { return this.destAirport; }
    public LocalDateTime getDepartureTime() { return this.departureDateTime; }
    public LocalDateTime getArrivalTime() { return this.arrivalDateTime; }
    public int getAvailableSeats() { return this.availableSeats; }
    public double getPrice() { return this.price; }

    @Override
    public String toString() {
        return String.format("Flight %s (%s) from %s to %s at %s, ETA at %s. Price: $%.2f",
                flightNumber, airline, srcAirport, destAirport, departureDateTime, arrivalDateTime, price);
    }

}
