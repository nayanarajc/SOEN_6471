package AirlinesApp;

import AirlinesApp.AirlinesDAOLayer.admin.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AirlinesApp.AirlinesServiceLayer.admin.AdminLoginService;

import java.util.List;

@RestController
public class AirlinesAppLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping("/hello")
    public List<AdminLogin> sayHi(){
        return adminLoginService.getAllAdminLogins();
    }
}
