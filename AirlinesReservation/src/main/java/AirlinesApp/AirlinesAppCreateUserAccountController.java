package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.user.CreateUserAccountService;
import AirlinesApp.AirlinesServiceLayer.user.ValidateUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlinesAppCreateUserAccountController {

    @Autowired
    private ValidateUserAccountService validateUserAccountService;

    @Autowired
    private CreateUserAccountService createUserAccountService;

    @ResponseBody
    @RequestMapping("/create-user")
    public boolean loginUserAccount(String userEmail, String userPassword) {
        if(validateUserAccountService.doesUserAccountExist(userEmail, userPassword)){
            return false;
        }
        createUserAccountService.createUserAccount(userEmail, userPassword);
        return true;
    }
}
