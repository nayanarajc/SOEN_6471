package AirlinesApp;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesServiceLayer.admin.AddFlightDetailsService;
import AirlinesApp.AirlinesServiceLayer.admin.ValidateAdminAccountService;
import AirlinesApp.AirlinesServiceLayer.flight.FlightDetailsService;
import AirlinesApp.AirlinesServiceLayer.client.SetUserLoginStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController 
public class AirlinesAppAdminLoginController {

    @Autowired
    private ValidateAdminAccountService validateAdminAccountService;

    @Autowired
    private SetUserLoginStatusService setUserLoginStatusService;
    
    @Autowired
    private FlightDetailsService flightDetailsService;
    
    @Autowired
    private AddFlightDetailsService addFlightDetailsService;

    @ResponseBody
    @RequestMapping(value="/login-admin",method = RequestMethod.POST)
    public boolean loginAdminAccount(@RequestParam String adminId, @RequestParam String userPassword) {
    	System.out.println(adminId);
    	System.out.println(userPassword);
        boolean doesAdminExist = validateAdminAccountService.doesAdminAccountExist(adminId, userPassword);
        if(!doesAdminExist){
            return false;
        }
        return setUserLoginStatusService.setAdminLoginStatusTrue(adminId);
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
    public boolean addFlights(@RequestParam String flightId,@RequestParam String airlines,@RequestParam String sourceLocation,
    		@RequestParam String destinationLocation,@RequestParam String departureDateAtSource,@RequestParam String departureTimeAtSource,
    		@RequestParam String arrivalDateAtDestination,@RequestParam String arrivalTimeAtDestination,@RequestParam String pricePerTicket,
    		@RequestParam String totalSeats,@RequestParam String totalBags) {
    
    	int seat = Integer.parseInt(totalSeats);
    	int Bags = Integer.parseInt(totalBags);
    	double price = Double.parseDouble(pricePerTicket);
    	long flightDuration = 0;
    	LocalDate departureDate = LocalDate.parse(departureDateAtSource);
    	LocalDate arrivalDate= LocalDate.parse(arrivalDateAtDestination);
    	LocalTime departureTime=LocalTime.parse(departureTimeAtSource,DateTimeFormatter.ISO_LOCAL_TIME);
    	LocalTime arrivalTime=LocalTime.parse(arrivalTimeAtDestination,DateTimeFormatter.ISO_LOCAL_TIME);
    	
    	//AC450 Air Canada Regina-YQR Saskatoon-YXE 2019-06-19 00:00 2019-06-11 01:00 0 2.0 2 2
    System.out.println(flightId+" "+airlines+" "+ sourceLocation+" "+ destinationLocation+" "+ departureDate+" "+ departureTime+" "+ arrivalDate+" "+ arrivalTime+" "+ flightDuration+" "+ price+" "+ seat+" "+Bags);
    	
    //	return addFlightDetailsService.addNewFlight("AC450", "Air Canada", "Regina-YQR", "Saskatoon-YXE", 2019-06-19, LocalTime.00:00, 2019-06-11, 01:00, 0, 2.0, 2, 2);
    	return addFlightDetailsService.addNewFlight(flightId,airlines, sourceLocation, destinationLocation, departureDate, departureTime, arrivalDate, arrivalTime, flightDuration, price, seat,Bags);
    }






}
