package AirlinesApp.AirlinesServiceLayer.reservation;

import AirlinesApp.AirlinesDAOLayer.reservation.Reservation;

import java.time.LocalDate;

public class ReservationDetails {

    private String passengerName;
    private LocalDate passengerDOB;
    private Reservation.Gender passengerGender;
    private String flightId;

    public ReservationDetails(String passengerName, LocalDate passengerDOB, Reservation.Gender passengerGender, String flightId) {
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

    public Reservation.Gender getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(Reservation.Gender passengerGender) {
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
