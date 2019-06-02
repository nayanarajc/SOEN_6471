package AirlinesApp.AirlinesServiceLayer.admin;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class AddFlightDetailsService {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    public boolean addNewFlight(String airlines, String sourceLocation, String destinationLocation, LocalDate departureDateAtSource, LocalTime departureTimeAtSource, LocalDate arrivalDateAtDestination, LocalTime arrivalTimeAtDestination, long flightDuration, double pricePerTicket, int totalSeats) {
        String flightId = sourceLocation+"-"+destinationLocation+"-"+airlines+"-"+departureDateAtSource+"-"+departureTimeAtSource;
        if(flightDetailsDAO.findById(flightId).isPresent()){
            return false;
        }
        FlightDetails flightDetails = new FlightDetails(flightId, airlines, sourceLocation, destinationLocation, departureDateAtSource, departureTimeAtSource, arrivalDateAtDestination, arrivalTimeAtDestination,  flightDuration,  pricePerTicket, totalSeats);
        flightDetailsDAO.save(flightDetails);
        return true;
    }

}
