package AirlinesApp.AirlinesServiceLayer.flight;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightDetailsService {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;


    public List<FlightDetails> getAvailableFlights(String sourceLocation, String destinationLocation, LocalDate travelDate) {
        List<FlightDetails> flightDetails = new ArrayList<>();
        flightDetailsDAO.findAll().forEach(flightDetails::add);
        return flightDetails.stream()
                .filter(flight -> flight.getSourceLocation().equalsIgnoreCase(sourceLocation) && flight.getDestinationLocation().equalsIgnoreCase(destinationLocation))
                .filter(flight -> flight.getDepartureDateAtSource().equals(travelDate))
                .collect(Collectors.toList());
    }
    
    public List<FlightDetails> getAllFlights() {
        List<FlightDetails> flightDetails = new ArrayList<>();
        flightDetailsDAO.findAll().forEach(flightDetails::add);
        return flightDetails.stream().collect(Collectors.toList());
    }
    
    
}
