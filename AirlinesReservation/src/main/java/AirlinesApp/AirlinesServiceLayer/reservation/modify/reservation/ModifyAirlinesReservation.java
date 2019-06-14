package AirlinesApp.AirlinesServiceLayer.reservation.modify.reservation;

import java.time.LocalDate;

public interface ModifyAirlinesReservation {

    boolean modifyReservationDates(String reservationId, LocalDate from);

    boolean modifyPassengerNames(String reservationId, String firstName, String lastName);
}
