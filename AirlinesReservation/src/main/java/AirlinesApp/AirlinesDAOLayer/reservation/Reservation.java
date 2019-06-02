package AirlinesApp.AirlinesDAOLayer.reservation;

import AirlinesApp.AirlinesDAOLayer.flight.FlightDetails;
import AirlinesApp.AirlinesDAOLayer.passenger.Passenger;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passengerId", foreignKey = @ForeignKey(name = "fk_reservation_passengerId"))
    private Passenger passenger;

    public Reservation() {
    }

    public Reservation(String reservationId, FlightDetails flightDetails, Passenger passenger) {
        this.reservationId = reservationId;
        this.flightDetails = flightDetails;
        this.passenger = passenger;
    }
}
