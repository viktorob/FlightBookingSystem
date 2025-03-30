package solid;
import java.util.Date;

public class Flight {
    private String flightNumber;
    private String airline;
    private String aircraftModel;
    private String srcAirport;
    private String destAirport;
    private Date departureTime;
    private Date arrivalTime;
    private int availableSeats;
    private double price;
    private float co2Emissions;

    public Flight(String flightNumber, String airline, String aircraftModel, String srcAirport, String destAirport, Date departureTime, Date arrivalTime, int availableSeats, double price, float co2Emissions) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.aircraftModel = aircraftModel;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.price = price;
        this.co2Emissions = co2Emissions;
    }

    public Flight getFlightDetails() {
        return this;
    }

    @Override
    public String toString() {
        return flightNumber + " from " + this.srcAirport + " to " + this.destAirport + " at " + departureTime;
    }

}
