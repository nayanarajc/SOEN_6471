package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.client.CreateUserAccountService;
import AirlinesApp.AirlinesServiceLayer.client.ValidateUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public boolean loginUserAccount(@RequestParam String userEmail,@RequestParam String userPassword,@RequestParam String firstname,@RequestParam String dob) {
        if(validateUserAccountService.doesUserAccountExist(userEmail, userPassword)){
            return false;
        }
        
        createUserAccountService.createUserAccount(userEmail,userPassword,firstname,dob);
        return true;
    }
}
