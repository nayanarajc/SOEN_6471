package AirlinesApp.AirlinesDAOLayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginDAO extends CrudRepository<AdminLogin, String> {

}
