package AirlinesApp.AirlinesServiceLayer.admin;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class ModifyFlightDetailsService {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    public boolean modifyFlight(String flightId,String airlines, String sourceLocation, String destinationLocation, LocalDate departureDateAtSource, LocalTime departureTimeAtSource, LocalDate arrivalDateAtDestination, LocalTime arrivalTimeAtDestination, long flightDuration, double pricePerTicket, int totalSeats,int totalBags) {
        //String flightId = sourceLocation+"-"+destinationLocation+"-"+airlines+"-"+departureDateAtSource+"-"+departureTimeAtSource;
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(flightId);
        if(!optionalFlightDetails.isPresent()){
            return false;
        }
        FlightDetails flightDetails = optionalFlightDetails.get();
        
        
        flightDetails.setSourceLocation(sourceLocation);
        flightDetails.setDestinationLocation(destinationLocation);
        flightDetails.setDepartureDateAtSource(departureDateAtSource);
        flightDetails.setArrivalDateAtDestination(arrivalDateAtDestination);
        flightDetails.setDepartureTimeAtSource(departureTimeAtSource);
        flightDetails.setArrivalTimeAtDestination(arrivalTimeAtDestination);
        flightDetails.setFlightDuration(0);
        flightDetails.setTotalBags(totalBags);
        flightDetails.setPricePerTicket(pricePerTicket);
        flightDetails.setTotalSeats(totalSeats);
        flightDetails.setAirlines(airlines);
        flightDetailsDAO.save(flightDetails);
        return true;
    }

   /* public boolean modifyFlightSeats(String airlines, String sourceLocation, String destinationLocation, LocalDate departureDateAtSource, LocalTime departureTimeAtSource, int totalSeats) {
        String flightId = sourceLocation+"-"+destinationLocation+"-"+airlines+"-"+departureDateAtSource+"-"+departureTimeAtSource;
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(flightId);
        if(!optionalFlightDetails.isPresent()){
            return false;
        }
        FlightDetails flightDetails = optionalFlightDetails.get();
        flightDetails.setTotalSeats(totalSeats);
        flightDetailsDAO.save(flightDetails);
        return true;
    }*/

}
