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



@RestController
public class AirlinesAppCreateReservationController {

    @Autowired
    private CreateAirlinesReservationService createAirlinesReservation;

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

}
