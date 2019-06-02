package AirlinesApp.AirlinesServiceLayer.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import AirlinesApp.AirlinesDAOLayer.passenger.Passenger;
import AirlinesApp.AirlinesDAOLayer.passenger.Passenger.PassengerGender;
import AirlinesApp.AirlinesDAOLayer.passenger.PassengerDAO;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.ReservationDAO;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreateReservationService {

    @Autowired
    private PassengerDAO passengerDAO;

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    public String createReservation(ReservationDetails reservationDetails) {
        List<Passenger> passengerList = new ArrayList<>();
        passengerDAO.findAll().forEach(passengerList::add);
        Optional<Passenger> optionalPassenger = passengerList.stream()
                .filter(p -> p.getPassengerName().equalsIgnoreCase(reservationDetails.getPassengerName()))
                .filter(p -> p.getPassengerDOB().equals(reservationDetails.getPassengerDOB()))
                .filter(p -> p.getPassengerGender().equals(reservationDetails.getPassengerGender()))
                .findFirst();
        Optional<FlightDetails> optionalFlightDetails = flightDetailsDAO.findById(reservationDetails.getFlightId());
        if(!optionalFlightDetails.isPresent()){
            return null;
        }
        String reservationId = RandomString.make(10);
        if(optionalPassenger.isPresent()){
            Reservation reservation = new Reservation(reservationId, optionalFlightDetails.get(), optionalPassenger.get());
            reservationDAO.save(reservation);
            return reservationId;
        }
        String passengerId = RandomString.make(7);
        Passenger passenger = new Passenger(passengerId, reservationDetails.getPassengerName(), reservationDetails.getPassengerDOB(), reservationDetails.getPassengerGender());
        passengerDAO.save(passenger);
        Reservation reservation = new Reservation(reservationId, optionalFlightDetails.get(), passenger);
        reservationDAO.save(reservation);
        return reservationId;

    }

    public class ReservationDetails {
        private String passengerName;
        private LocalDate passengerDOB;
        private PassengerGender passengerGender;
        private String flightId;

        public ReservationDetails(String passengerName, LocalDate passengerDOB, PassengerGender passengerGender, String flightId) {
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

        public PassengerGender getPassengerGender() {
            return passengerGender;
        }

        public void setPassengerGender(PassengerGender passengerGender) {
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

