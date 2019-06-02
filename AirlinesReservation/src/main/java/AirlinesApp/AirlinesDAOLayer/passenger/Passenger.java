package AirlinesApp.AirlinesDAOLayer.passenger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(
        name = "passengers"
)
public class Passenger {

    @Id
    private String passengerId;

    private String passengerName;

    private LocalDate passengerDOB;

    private PassengerGender passengerGender;

    public Passenger() {
    }

    public Passenger(String passengerId, String passengerName, LocalDate passengerDOB, PassengerGender passengerGender) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerDOB = passengerDOB;
        this.passengerGender = passengerGender;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDate getPassengerDOB() {
        return passengerDOB;
    }

    public void setPassengerDOB(LocalDate passengerDOB) {
        this.passengerDOB = passengerDOB;
    }

    public PassengerGender getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(PassengerGender passengerGender) {
        this.passengerGender = passengerGender;
    }

    public enum PassengerGender{
        MALE,  FEMALE, OTHERS
    }

}
