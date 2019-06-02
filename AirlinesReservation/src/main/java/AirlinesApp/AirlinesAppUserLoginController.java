package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.user.ValidateUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlinesAppUserLoginController {

    @Autowired
    private ValidateUserAccountService validateUserAccountService;

    @ResponseBody
    @RequestMapping("/login-user")
    public boolean loginUserAccount(String userEmail, String userPassword) {
        return validateUserAccountService.doesUserAccountExist(userEmail, userPassword);
    }

}
