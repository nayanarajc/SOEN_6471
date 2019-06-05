package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.user.ValidateUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlinesAppUserLoginController {

    @Autowired
    private ValidateUserAccountService validateUserAccountService;

    @ResponseBody
    @RequestMapping(value="/login-user",method = RequestMethod.POST)
    public boolean loginUserAccount(@RequestParam String userEmail, @RequestParam String userPassword) {
        return validateUserAccountService.doesUserAccountExist(userEmail, userPassword);
    }

}
