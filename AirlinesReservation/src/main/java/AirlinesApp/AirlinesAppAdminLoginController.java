package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.admin.ValidateAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlinesAppAdminLoginController {

    @Autowired
    private ValidateAdminAccountService validateAdminAccountService;

    @ResponseBody
    @RequestMapping("/login-admin")
    public boolean loginAdminAccount(String adminId, String userPassword) {
        return validateAdminAccountService.doesAdminAccountExist(adminId, userPassword);
    }

}
