package AirlinesApp.AirlinesDAOLayer.flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDetailsDAO extends CrudRepository<FlightDetails, String> {
}
