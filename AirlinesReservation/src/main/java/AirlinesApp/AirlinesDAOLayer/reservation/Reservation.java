package AirlinesApp.AirlinesDAOLayer.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "reservations"
)
public class Reservation {

    @Id
    private String reservationId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId", foreignKey = @ForeignKey(name = "fk_reservation_flight_details"))
    private FlightDetails flightDetails;

    private String passengerName;

    private LocalDate DOB;

    private Gender gender;

    public Reservation() {
    }

    public Reservation(String reservationId, FlightDetails flightDetails, String passengerName, LocalDate DOB, Gender gender) {
        this.reservationId = reservationId;
        this.flightDetails = flightDetails;
        this.passengerName = passengerName;
        this.DOB = DOB;
        this.gender = gender;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public enum Gender{
        MALE, FEMALE, OTHER
    }
}
