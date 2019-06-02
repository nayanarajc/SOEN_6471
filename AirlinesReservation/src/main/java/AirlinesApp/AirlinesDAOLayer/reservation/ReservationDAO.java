package AirlinesApp.AirlinesDAOLayer.reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDAO extends CrudRepository<Reservation, String> {
}

