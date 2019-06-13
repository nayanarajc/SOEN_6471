package AirlinesApp.AirlinesServiceLayer.reservation.create.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.ReservationDAO;
import AirlinesApp.AirlinesServiceLayer.reservation.ReservationDetails;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component(value = "general")
public class CreateGeneralAirwaysReservationService implements CreateAirlinesReservation {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    public String createReservation(ReservationDetails reservationDetails) {
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(reservationDetails.getFlightId());
        if (!optionalFlightDetails.isPresent()) {
            return null;
        }
        String reservationId = "Gen-" + reservationDetails.getFlightId() + RandomString.make(10);
        Reservation reservation = new Reservation(reservationId, optionalFlightDetails.get(), reservationDetails.getPassengerName(), reservationDetails.getPassengerDOB(), reservationDetails.getPassengerGender());
        reservationDAO.save(reservation);
        return reservationId;
    }

}