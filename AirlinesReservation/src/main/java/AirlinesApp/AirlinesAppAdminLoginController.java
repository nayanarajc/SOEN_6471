package AirlinesApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
    @RequestMapping(value="/add-Flights",method = RequestMethod.GET)
    public boolean addFlights() {
    	//insert into flight_details values('001','Air Canada','2019-06-28','11:30 AM','2019-06-25','1:30 PM','Victoria-YYJ','2','430','Vancouver-YVR','120'); 

    	LocalDate departureDateAtSource = LocalDate.of(2019, Month.JUNE, 28);
    	LocalDate arrivalDateAtDestination = LocalDate.of(2019, Month.JUNE, 29);
    	
    	String airlines="Air Canada";
    	String sourceLocation="Victoria-YYJ"; 
    	String destinationLocation="Vancouver-YVR"; 
    	LocalTime departureTimeAtSource= LocalTime.of(11, 30);
    	LocalTime arrivalTimeAtDestination= LocalTime.of(13,30);
    	long flightDuration=2;
    	double pricePerTicket=320;
    	int totalSeats=90;
    	
    	return addFlightDetailsService.addNewFlight(airlines, sourceLocation, destinationLocation, departureDateAtSource, departureTimeAtSource, arrivalDateAtDestination, arrivalTimeAtDestination, flightDuration, pricePerTicket, totalSeats);
    }
   
  
    @ResponseBody
    @RequestMapping(value="/all-Flights",method = RequestMethod.GET)
    public List<FlightDetails> allFlights() {
    	return flightDetailsService.getAllFlights();
    }
    
	    
}
