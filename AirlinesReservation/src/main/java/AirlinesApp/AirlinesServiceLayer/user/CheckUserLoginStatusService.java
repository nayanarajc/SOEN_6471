package AirlinesApp.AirlinesServiceLayer.user;

import AirlinesApp.AirlinesDAOLayer.user.UserLogin;
import AirlinesApp.AirlinesDAOLayer.user.UserLoginDAO;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckUserLoginStatusService {

    @Autowired
    private UserLoginDAO userLoginDAO;

    public boolean isUserLoggedIn(String userEmail) {
        UserLogin userLogin = userLoginDAO.findById(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(UserLogin.class, userEmail));
        return userLogin.isLoggedIn();
    }
}
