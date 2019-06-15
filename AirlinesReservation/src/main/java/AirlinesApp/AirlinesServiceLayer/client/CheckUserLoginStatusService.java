package AirlinesApp.AirlinesServiceLayer.client;

import AirlinesApp.AirlinesDAOLayer.client.ClientLogin;
import AirlinesApp.AirlinesDAOLayer.client.ClientLoginDAO;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckUserLoginStatusService {

    @Autowired
    private ClientLoginDAO clientLoginDAO;

    public boolean isUserLoggedIn(String userEmail) {
        ClientLogin clientLogin = clientLoginDAO.findById(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(ClientLogin.class, userEmail));
        return clientLogin.isLoggedIn();
    }
}
