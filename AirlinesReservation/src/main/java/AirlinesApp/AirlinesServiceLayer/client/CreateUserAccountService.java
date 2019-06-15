package AirlinesApp.AirlinesServiceLayer.client;

import AirlinesApp.AirlinesDAOLayer.client.ClientLogin;
import AirlinesApp.AirlinesDAOLayer.client.ClientLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserAccountService {

    @Autowired
    private ClientLoginDAO clientLoginDAO;

    public void createUserAccount(String userEmail, String userPassword, String name, String dob) {
        String userId = name;
        ClientLogin newUser = new ClientLogin(userId, userEmail, userPassword, dob, false);
        System.out.println(userId + " " + userEmail + " " + userPassword + " " + dob);
        clientLoginDAO.save(newUser);
    }
}
