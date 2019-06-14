package AirlinesApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesServiceLayer.admin.AddFlightDetailsService;
import AirlinesApp.AirlinesServiceLayer.admin.ValidateAdminAccountService;
import AirlinesApp.AirlinesServiceLayer.flight.FlightDetailsService;



@RestController 
public class AirlinesAppAdminLoginController {

    @Autowired
    private ValidateAdminAccountService validateAdminAccountService;
    
    @Autowired
    private FlightDetailsService flightDetailsService;
    
    @Autowired
    private AddFlightDetailsService addFlightDetailsService;

    @ResponseBody
    @RequestMapping(value="/login-admin",method = RequestMethod.POST)
    public boolean loginAdminAccount(@RequestParam String adminId, @RequestParam String userPassword) {
    	System.out.println(adminId);
    	System.out.println(userPassword);
        return validateAdminAccountService.doesAdminAccountExist(adminId, userPassword);
    }
   
    @ResponseBody
    @RequestMapping(value="/view-Flights",method = RequestMethod.GET)
    public List<FlightDetails> viewFlights() {
    	
    	List<String> flights = new ArrayList<String>();
    	flights.add("Air Canada");
    	LocalDate dateTravel = LocalDate.of(2019, Month.JUNE, 25);
    	
    	List<FlightDetails> flightDetails = flightDetailsService.getAvailableFlights("Vancouver-YVR", "Victoria-YYJ", flights, dateTravel);
    	System.out.println(flightDetails);
    	
    	return flightDetails;
    }
   
    @ResponseBody
    @RequestMapping(value="/all-Flights",method = RequestMethod.GET)
    public List<FlightDetails> allFlights() {
    	return flightDetailsService.getAllFlights();
    }
   
    
    @ResponseBody
    @RequestMapping(value="/add-Flights",method = RequestMethod.POST)
    public boolean addFlights(@RequestParam String flightId,@RequestParam String airlines,@RequestParam String sourceLocation,@RequestParam String destinationLocation,@RequestParam String departureDateAtSource,@RequestParam String departureTimeAtSource,@RequestParam String arrivalDateAtDestination,@RequestParam String arrivalTimeAtDestination,@RequestParam String pricePerTicket,@RequestParam String totalSeats) {
    
    	int seat = Integer.parseInt(totalSeats);
    	double price = Double.parseDouble(pricePerTicket);
    	long flightDuration = 0;
    	LocalDate departureDate = LocalDate.parse(departureDateAtSource);
    	LocalDate arrivalDate= LocalDate.parse(arrivalDateAtDestination);
    	LocalTime departureTime=LocalTime.parse(departureTimeAtSource,DateTimeFormatter.ISO_LOCAL_TIME);
    	LocalTime arrivalTime=LocalTime.parse(arrivalTimeAtDestination,DateTimeFormatter.ISO_LOCAL_TIME);
    	
    	return addFlightDetailsService.addNewFlight(flightId,airlines, sourceLocation, destinationLocation, departureDate, departureTime, arrivalDate, arrivalTime, flightDuration, price, seat);
    }
   
  
    
    
    
	    
}
