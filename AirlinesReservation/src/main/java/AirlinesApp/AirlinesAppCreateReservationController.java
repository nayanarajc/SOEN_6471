package AirlinesApp;

import AirlinesApp.AirlinesDAOLayer.reservation.Reservation.Gender;
import AirlinesApp.AirlinesServiceLayer.reservation.CreateReservationService;
import AirlinesApp.AirlinesServiceLayer.reservation.CreateReservationService.ReservationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AirlinesAppCreateReservationController {

    @Autowired
    private CreateReservationService createReservationService;

    @ResponseBody
    @RequestMapping("/create-reservation")
    public String loginUserAccount(String passengerName, LocalDate passengerDOB, Gender passengerGender, String flightId) {
        ReservationDetails reservationDetails = new ReservationDetails(passengerName, passengerDOB, passengerGender, flightId);
        return createReservationService.createReservation(reservationDetails);
    }

}
