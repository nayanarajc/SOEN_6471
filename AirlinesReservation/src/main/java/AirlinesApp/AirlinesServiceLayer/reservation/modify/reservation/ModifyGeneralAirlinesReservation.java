package AirlinesApp.AirlinesServiceLayer.reservation.modify.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.flight.FlightDetailsDAO;
import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.ReservationDAO;
import AirlinesApp.AirlinesServiceLayer.reservation.ManageReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "modifyGeneral")
public class ModifyGeneralAirlinesReservation implements ModifyAirlinesReservation, ManageReservation {

    @Autowired
    private FlightDetailsDAO flightDetailsDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public boolean modifyReservationDates(String reservationId, LocalDate from) {
        Optional<Reservation> optionalReservation = reservationDAO.findById(reservationId);
        if (!optionalReservation.isPresent()) {
            return false;
        }
        Reservation reservation = optionalReservation.get();
        FlightDetails flightDetailsOld = reservation.getFlightDetails();
        List<FlightDetails> allFlights = new ArrayList<>();
        flightDetailsDAO.findAll().forEach(allFlights::add);
        Optional<FlightDetails> newFlightDetails = allFlights.stream()
                .filter(flight -> flightDetailsOld.getSourceLocation().equals(flight.getSourceLocation()))
                .filter(flight -> flightDetailsOld.getDestinationLocation().equals(flight.getDestinationLocation()))
                .filter(flight -> flight.getDepartureDateAtSource().equals(from))
                .filter(flight -> flight.getAirlines().equals(flightDetailsOld.getAirlines()))
                .findAny();
        if (!newFlightDetails.isPresent()) {
            return false;
        }
        reservation.setFlightDetails(newFlightDetails.get());
        reservationDAO.save(reservation);
        return true;
    }

    @Override
    public boolean modifyPassengerNames(String reservationId, String firstName, String lastName) {
        return false;
    }
}
