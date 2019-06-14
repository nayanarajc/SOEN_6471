package AirlinesApp.AirlinesDAOLayer.flight;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(
        name = "flight_details"
)
public class FlightDetails {

    @Id
    private String flightId;

    private String airlines;

    private String sourceLocation;

    private String destinationLocation;

    private LocalDate departureDateAtSource;

    private LocalTime departureTimeAtSource;

    private LocalDate arrivalDateAtDestination;

    private LocalTime arrivalTimeAtDestination;

    private long flightDuration;

    private double pricePerTicket;

    private int totalSeats;
    
    private int totalBags;

  
	public  FlightDetails(){
    }

    public FlightDetails(String flightId, String airlines, String sourceLocation, String destinationLocation, LocalDate departureDateAtSource, LocalTime departureTimeAtSource, LocalDate arrivalDateAtDestination, LocalTime arrivalTimeAtDestination, long flightDuration, double pricePerTicket, int totalSeats,int totalBags){
        this.flightId = flightId;
        this.airlines = airlines;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.departureDateAtSource = departureDateAtSource;
        this.departureTimeAtSource = departureTimeAtSource;
        this.arrivalDateAtDestination = arrivalDateAtDestination;
        this.arrivalTimeAtDestination = arrivalTimeAtDestination;
        this.flightDuration = flightDuration;
        this.pricePerTicket = pricePerTicket;
        this.totalSeats = totalSeats;
        this.totalBags =totalBags;
    }

  
    public int getTotalBags() {
  		return totalBags;
  	}

  	public void setTotalBags(int totalBags) {
  		this.totalBags = totalBags;
  	}
   
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(double pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }

    public long getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(long flightDuration) {
        this.flightDuration = flightDuration;
    }

    public LocalTime getArrivalTimeAtDestination() {
        return arrivalTimeAtDestination;
    }

    public void setArrivalTimeAtDestination(LocalTime arrivalTimeAtDestination) {
        this.arrivalTimeAtDestination = arrivalTimeAtDestination;
    }

    public LocalDate getArrivalDateAtDestination() {
        return arrivalDateAtDestination;
    }

    public void setArrivalDateAtDestination(LocalDate arrivalDateAtDestination) {
        this.arrivalDateAtDestination = arrivalDateAtDestination;
    }

    public LocalTime getDepartureTimeAtSource() {
        return departureTimeAtSource;
    }

    public void setDepartureTimeAtSource(LocalTime departureTimeAtSource) {
        this.departureTimeAtSource = departureTimeAtSource;
    }

    public LocalDate getDepartureDateAtSource() {
        return departureDateAtSource;
    }

    public void setDepartureDateAtSource(LocalDate departureDateAtSource) {
        this.departureDateAtSource = departureDateAtSource;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }
}
