package AirlinesApp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation.Gender;
import AirlinesApp.AirlinesServiceLayer.reservation.ReservationDetails;
import AirlinesApp.AirlinesServiceLayer.reservation.book.CreateAirlinesReservationService;
import AirlinesApp.AirlinesServiceLayer.reservation.cancel.CancelAirlinesReservationServiceImpl;
import AirlinesApp.AirlinesServiceLayer.reservation.modify.ModifyAirlinesReservationServiceImpl;



@RestController
public class AirlinesAppCreateReservationController {

    @Autowired
    private CreateAirlinesReservationService createAirlinesReservation;
    
    @Autowired
    private CancelAirlinesReservationServiceImpl cancelAirlinesReservationServiceImpl;
    
    @Autowired
    private ModifyAirlinesReservationServiceImpl modifyAirlinesReservationServiceImpl;

    @ResponseBody
    @RequestMapping(value ="/create-reservation",method = RequestMethod.POST)
    public String loginUserAccount(@RequestParam String passengerName,@RequestParam String passengerDOB,@RequestParam String passengerGender,@RequestParam String flightId) {
    	
    	LocalDate passenger_DOB = LocalDate.parse(passengerDOB);
    	Reservation.Gender  gender;
    
    	if(passengerGender.toUpperCase().equals("MALE"))
    		gender = Gender.MALE;
    	else if(passengerGender.toUpperCase().equals("FEMALE"))
    		gender = Gender.FEMALE;
    	else
    		gender = Gender.OTHER;
    	
    	System.out.println(passengerName+" "+ passenger_DOB+" "+ gender+" "+ flightId);
    	
        ReservationDetails reservationDetails = new ReservationDetails(passengerName, passenger_DOB, gender, flightId);
        
        return createAirlinesReservation.createReservation(reservationDetails);
    }
    
    @ResponseBody
    @RequestMapping(value ="/cancel-reservation",method = RequestMethod.POST)
    public boolean CancelReservation (@RequestParam String reservationId) {
    	
    	
		return 	cancelAirlinesReservationServiceImpl.cancelReservation(reservationId);
    }
    
    @ResponseBody
    @RequestMapping(value ="/modifyPassenger-reservation",method = RequestMethod.POST)
    public boolean modifyPassengerNames (@RequestParam String reservationId, @RequestParam String firstName) {
    	String lastname="";
    	return 	modifyAirlinesReservationServiceImpl.modifyPassengerNames(reservationId,firstName,lastname);
    }

}
