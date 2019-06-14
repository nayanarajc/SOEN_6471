package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.user.SetUserLoginStatusService;
import AirlinesApp.AirlinesServiceLayer.user.ValidateUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirlinesAppUserLoginController {

    @Autowired
    private ValidateUserAccountService validateUserAccountService;

    @Autowired
    private SetUserLoginStatusService setUserLoginStatusService;

    @ResponseBody
    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public boolean loginUserAccount(@RequestParam String userEmail, @RequestParam String userPassword) {
        System.out.println(userEmail);
        System.out.println(userPassword);
        boolean doesUserExist = validateUserAccountService.doesUserAccountExist(userEmail, userPassword);
        if (!doesUserExist) {
            return false;
        }
        return setUserLoginStatusService.setUserLoginStatusTrue(userEmail);
    }

}
