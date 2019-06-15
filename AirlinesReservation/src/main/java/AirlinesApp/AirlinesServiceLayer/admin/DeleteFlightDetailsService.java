package AirlinesApp.AirlinesServiceLayer.admin;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class DeleteFlightDetailsService {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    public boolean deleteFlight(String flightId) {
       // String flightId = sourceLocation+"-"+destinationLocation+"-"+airlines+"-"+departureDateAtSource+"-"+departureTimeAtSource;
        Optional<FlightDetails> flightDetails = flightDetailsDAO.findById(flightId);
        if(!flightDetails.isPresent()){
            return false;
        }
        flightDetailsDAO.deleteById(flightId);
        return true;
    }

}
