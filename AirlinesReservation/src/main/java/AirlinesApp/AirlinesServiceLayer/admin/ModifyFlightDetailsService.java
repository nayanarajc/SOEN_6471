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

    public boolean modifyFlightPrice(String airlines, String sourceLocation, String destinationLocation, LocalDate departureDateAtSource, LocalTime departureTimeAtSource, double pricePerTicket) {
        String flightId = sourceLocation+"-"+destinationLocation+"-"+airlines+"-"+departureDateAtSource+"-"+departureTimeAtSource;
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(flightId);
        if(!optionalFlightDetails.isPresent()){
            return false;
        }
        FlightDetails flightDetails = optionalFlightDetails.get();
        flightDetails.setPricePerTicket(pricePerTicket);
        flightDetailsDAO.save(flightDetails);
        return true;
    }

    public boolean modifyFlightSeats(String airlines, String sourceLocation, String destinationLocation, LocalDate departureDateAtSource, LocalTime departureTimeAtSource, int totalSeats) {
        String flightId = sourceLocation+"-"+destinationLocation+"-"+airlines+"-"+departureDateAtSource+"-"+departureTimeAtSource;
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(flightId);
        if(!optionalFlightDetails.isPresent()){
            return false;
        }
        FlightDetails flightDetails = optionalFlightDetails.get();
        flightDetails.setTotalSeats(totalSeats);
        flightDetailsDAO.save(flightDetails);
        return true;
    }

}
