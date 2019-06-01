package AirlinesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AirlinesApp.AirlinesServiceLayer.AdminLoginService;

@RestController
public class AirlinesAppLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping("/hello")
    public String sayHi(){
        return "Say hi";
//        return "admin_login.html";
    }
}
