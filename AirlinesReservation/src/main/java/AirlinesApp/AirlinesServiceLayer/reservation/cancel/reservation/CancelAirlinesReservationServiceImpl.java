package AirlinesApp.AirlinesServiceLayer.reservation.cancel.reservation;

import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;
import AirlinesApp.AirlinesDAOLayer.reservation.ReservationDAO;
import AirlinesApp.AirlinesServiceLayer.reservation.ManageReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancelAirlinesReservationServiceImpl  implements CancelAirlinesReservationService, ManageReservation {

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public boolean cancelReservation(String reservationId) {

        Optional<Reservation> optionalReservation = reservationDAO.findById(reservationId);
        if (!optionalReservation.isPresent()) {
            return false;
        }
        Reservation reservation = optionalReservation.get();
        reservationDAO.delete(reservation);
        return true;
    }

}
