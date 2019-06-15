package AirlinesApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesServiceLayer.admin.AddFlightDetailsService;
import AirlinesApp.AirlinesServiceLayer.admin.DeleteFlightDetailsService;
import AirlinesApp.AirlinesServiceLayer.admin.ModifyFlightDetailsService;
import AirlinesApp.AirlinesServiceLayer.admin.ValidateAdminAccountService;
import AirlinesApp.AirlinesServiceLayer.client.SetUserLoginStatusService;
import AirlinesApp.AirlinesServiceLayer.flight.FlightDetailsService;

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
	
	@Autowired
	private ModifyFlightDetailsService editFlightDetailsService;

	@Autowired
	private DeleteFlightDetailsService deleteFlightDetailsService;

	@ResponseBody
	@RequestMapping(value = "/login-admin", method = RequestMethod.POST)
	public boolean loginAdminAccount(@RequestParam String adminId, @RequestParam String userPassword) {
		System.out.println(adminId);
		System.out.println(userPassword);
		boolean doesAdminExist = validateAdminAccountService.doesAdminAccountExist(adminId, userPassword);
		if (!doesAdminExist) {
			return false;
		}
		return setUserLoginStatusService.setAdminLoginStatusTrue(adminId);
	}

	@ResponseBody
	@RequestMapping(value = "/view-Flights", method = RequestMethod.POST)
	public List<FlightDetails> viewFlights(@RequestParam String sourceLocation,
			@RequestParam String destinationLocation, @RequestParam String departureDateAtSource) {

		LocalDate departureDate = LocalDate.parse(departureDateAtSource);
		System.out.println(sourceLocation + " " + destinationLocation + " " + departureDate);
		List<FlightDetails> flightDetails = flightDetailsService.getAvailableFlights(sourceLocation,
				destinationLocation, departureDate);
		// System.out.println(flightDetails);

		return flightDetails;
	}

	@ResponseBody
	@RequestMapping(value = "/delete-Flights", method = RequestMethod.POST)
	public boolean deleteFlights(@RequestParam String flightId) {
		return deleteFlightDetailsService.deleteFlight(flightId);
	}

	@ResponseBody
	@RequestMapping(value = "/add-Flights", method = RequestMethod.POST)
	public boolean addFlights(@RequestParam String flightId, @RequestParam String airlines,
			@RequestParam String sourceLocation, @RequestParam String destinationLocation,
			@RequestParam String departureDateAtSource, @RequestParam String departureTimeAtSource,
			@RequestParam String arrivalDateAtDestination, @RequestParam String arrivalTimeAtDestination,
			@RequestParam String pricePerTicket, @RequestParam String totalSeats, @RequestParam String totalBags) {

		int seat = Integer.parseInt(totalSeats);
		int Bags = Integer.parseInt(totalBags);
		double price = Double.parseDouble(pricePerTicket);
		long flightDuration = 0;
		LocalDate departureDate = LocalDate.parse(departureDateAtSource);
		LocalDate arrivalDate = LocalDate.parse(arrivalDateAtDestination);
		LocalTime departureTime = LocalTime.parse(departureTimeAtSource, DateTimeFormatter.ISO_LOCAL_TIME);
		LocalTime arrivalTime = LocalTime.parse(arrivalTimeAtDestination, DateTimeFormatter.ISO_LOCAL_TIME);

		System.out.println(flightId + " " + airlines + " " + sourceLocation + " " + destinationLocation + " "
				+ departureDate + " " + departureTime + " " + arrivalDate + " " + arrivalTime + " " + flightDuration
				+ " " + price + " " + seat + " " + Bags);
		return addFlightDetailsService.addNewFlight(flightId, airlines, sourceLocation, destinationLocation,
				departureDate, departureTime, arrivalDate, arrivalTime, flightDuration, price, seat, Bags);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/edit-Flights", method = RequestMethod.POST)
	public boolean editFlights(@RequestParam String flightId, @RequestParam String airlines,
			@RequestParam String sourceLocation, @RequestParam String destinationLocation,
			@RequestParam String departureDateAtSource, @RequestParam String departureTimeAtSource,
			@RequestParam String arrivalDateAtDestination, @RequestParam String arrivalTimeAtDestination,
			@RequestParam String pricePerTicket, @RequestParam String totalSeats, @RequestParam String totalBags) {

		int seat = Integer.parseInt(totalSeats);
		int Bags = Integer.parseInt(totalBags);
		double price = Double.parseDouble(pricePerTicket);
		long flightDuration = 0;
		LocalDate departureDate = LocalDate.parse(departureDateAtSource);
		LocalDate arrivalDate = LocalDate.parse(arrivalDateAtDestination);
		LocalTime departureTime = LocalTime.parse(departureTimeAtSource, DateTimeFormatter.ISO_LOCAL_TIME);
		LocalTime arrivalTime = LocalTime.parse(arrivalTimeAtDestination, DateTimeFormatter.ISO_LOCAL_TIME);

		System.out.println(flightId + " " + airlines + " " + sourceLocation + " " + destinationLocation + " "
				+ departureDate + " " + departureTime + " " + arrivalDate + " " + arrivalTime + " " + flightDuration
				+ " " + price + " " + seat + " " + Bags);
		return editFlightDetailsService.modifyFlight(flightId, airlines, sourceLocation, destinationLocation,
				departureDate, departureTime, arrivalDate, arrivalTime, flightDuration, price, seat, Bags);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@ResponseBody
	@RequestMapping(value = "/all-Flights", method = RequestMethod.GET)
	public List<FlightDetails> allFlights() {
		return flightDetailsService.getAllFlights();
	}

}
