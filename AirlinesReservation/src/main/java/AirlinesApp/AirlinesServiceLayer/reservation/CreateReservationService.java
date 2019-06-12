package AirlinesApp.AirlinesServiceLayer.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation.Gender;
import AirlinesApp.AirlinesDAOLayer.reservation.ReservationDAO;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CreateReservationService {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    public String createReservation(ReservationDetails reservationDetails) {
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(reservationDetails.getFlightId());
        if(!optionalFlightDetails.isPresent()){
            return null;
        }
        String reservationId = RandomString.make(10);
        Reservation reservation = new Reservation(reservationId, optionalFlightDetails.get(), reservationDetails.getPassengerName(), reservationDetails.getPassengerDOB(), reservationDetails.getPassengerGender());
        reservationDAO.save(reservation);
        return reservationId;

    }

    public static class ReservationDetails {
        private String passengerName;
        private LocalDate passengerDOB;
        private Gender passengerGender;
        private String flightId;

        public ReservationDetails(String passengerName, LocalDate passengerDOB, Gender passengerGender, String flightId) {
            this.passengerName = passengerName;
            this.passengerDOB = passengerDOB;
            this.passengerGender = passengerGender;
            this.flightId = flightId;
        }

        public String getFlightId() {
            return flightId;
        }

        public void setFlightId(String flightId) {
            this.flightId = flightId;
        }

        public Gender getPassengerGender() {
            return passengerGender;
        }

        public void setPassengerGender(Gender passengerGender) {
            this.passengerGender = passengerGender;
        }

        public LocalDate getPassengerDOB() {
            return passengerDOB;
        }

        public void setPassengerDOB(LocalDate passengerDOB) {
            this.passengerDOB = passengerDOB;
        }

        public String getPassengerName() {
            return passengerName;
        }

        public void setPassengerName(String passengerName) {
            this.passengerName = passengerName;
        }
    }
}

