package AirlinesApp;

import AirlinesApp.AirlinesDAOLayer.reservation.Reservation.Gender;
import AirlinesApp.AirlinesServiceLayer.reservation.ReservationDetails;
import AirlinesApp.AirlinesServiceLayer.reservation.create.reservation.CreateAirlinesReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AirlinesAppCreateReservationController {

    @Autowired
    @Qualifier("british")
    private CreateAirlinesReservation createBritishAirlinesReservation;

    @Autowired
    @Qualifier("lufthansa")
    private CreateAirlinesReservation createLufthanzaAirlinesReservation;

    @Autowired
    @Qualifier("general")
    private CreateAirlinesReservation createGeneralAirlinesReservation;

    @ResponseBody
    @RequestMapping("/create-reservation")
    public String loginUserAccount(String passengerName, LocalDate passengerDOB, Gender passengerGender, String flightId) {
        ReservationDetails reservationDetails = new ReservationDetails(passengerName, passengerDOB, passengerGender, flightId);
        if(flightId.contains("lufthansa")){
            return createLufthanzaAirlinesReservation.createReservation(reservationDetails);
        }
        else if(flightId.contains("british")){
            return createBritishAirlinesReservation.createReservation(reservationDetails);
        }
        return createGeneralAirlinesReservation.createReservation(reservationDetails);
    }

}
