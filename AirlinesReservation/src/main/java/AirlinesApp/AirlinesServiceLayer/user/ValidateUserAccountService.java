package AirlinesApp.AirlinesServiceLayer.user;

import AirlinesApp.AirlinesDAOLayer.user.UserLogin;
import AirlinesApp.AirlinesDAOLayer.user.UserLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateUserAccountService {

    @Autowired
    private UserLoginDAO userLoginDAO;

    public boolean doesUserAccountExist(String userEmail, String userPassword) {
        List<UserLogin> userLogins = new ArrayList<>();
        userLoginDAO.findAll().forEach(userLogins::add);
        return userLogins.stream()
                .anyMatch(userLogin -> userLogin.getUserEmail().equalsIgnoreCase(userEmail) && userLogin.getUserPassword().equals(userPassword));
    }

}
