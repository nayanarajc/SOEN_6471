package AirlinesApp.AirlinesServiceLayer.user;

import AirlinesApp.AirlinesDAOLayer.client.ClientLogin;
import AirlinesApp.AirlinesDAOLayer.client.ClientLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateUserAccountService {

    @Autowired
    private ClientLoginDAO clientLoginDAO;

    public boolean doesUserAccountExist(String userEmail, String userPassword) {
        List<ClientLogin> clientLogins = new ArrayList<>();
        clientLoginDAO.findAll().forEach(clientLogins::add);
        return clientLogins.stream()
                .anyMatch(userLogin -> userLogin.getUserEmail().equalsIgnoreCase(userEmail) && userLogin.getUserPassword().equals(userPassword));
    }

}
