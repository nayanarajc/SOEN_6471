package AirlinesApp.AirlinesServiceLayer.user;

import AirlinesApp.AirlinesDAOLayer.user.UserLogin;
import AirlinesApp.AirlinesDAOLayer.user.UserLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserAccountService {

    @Autowired
    private UserLoginDAO userLoginDAO;

    public void createUserAccount(String userEmail, String userPassword,String name,String dob) {
        String userId = name;
        UserLogin newUser = new UserLogin(userId, userEmail, userPassword,dob);
        System.out.println(userId+" "+userEmail+" "+userPassword+" "+dob);
        userLoginDAO.save(newUser);
    }
}
