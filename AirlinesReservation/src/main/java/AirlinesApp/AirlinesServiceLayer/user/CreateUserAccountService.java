package AirlinesApp.AirlinesServiceLayer.user;

import AirlinesApp.AirlinesDAOLayer.user.UserLogin;
import AirlinesApp.AirlinesDAOLayer.user.UserLoginDAO;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserAccountService {

    @Autowired
    private UserLoginDAO userLoginDAO;

    public void createUserAccount(String userEmail, String userPassword) {
        String userId = RandomString.make(7);
        UserLogin newUser = new UserLogin(userId, userEmail, userPassword);
        userLoginDAO.save(newUser);
    }
}