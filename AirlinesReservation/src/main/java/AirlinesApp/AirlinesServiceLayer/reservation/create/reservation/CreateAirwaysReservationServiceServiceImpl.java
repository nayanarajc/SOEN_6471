package AirlinesApp.AirlinesServiceLayer.reservation.create.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.ReservationDAO;
import AirlinesApp.AirlinesServiceLayer.reservation.ManageReservation;
import AirlinesApp.AirlinesServiceLayer.reservation.ReservationDetails;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateAirwaysReservationServiceServiceImpl implements CreateAirlinesReservationService, ManageReservation {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    public String createReservation(ReservationDetails reservationDetails) {
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(reservationDetails.getFlightId());
        if (!optionalFlightDetails.isPresent()) {
            return null;
        }
        String reservationId = RandomString.make(10);
        FlightDetails flightDetails = optionalFlightDetails.get();
        Reservation reservation = new Reservation(reservationId, flightDetails, reservationDetails.getPassengerName(), reservationDetails.getPassengerDOB(), reservationDetails.getPassengerGender());
        reservationDAO.save(reservation);
        int availableSeats = flightDetails.getTotalSeats();
        flightDetails.setTotalSeats(availableSeats - 1);
        flightDetailsDAO.save(flightDetails);
        return reservationId;
    }


}

