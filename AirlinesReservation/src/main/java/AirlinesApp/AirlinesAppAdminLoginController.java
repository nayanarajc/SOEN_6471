package AirlinesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import AirlinesApp.AirlinesServiceLayer.admin.ValidateAdminAccountService;

@RestController 
public class AirlinesAppAdminLoginController {

    @Autowired
    private ValidateAdminAccountService validateAdminAccountService;

    @ResponseBody
    @RequestMapping(value="/login-admin",method = RequestMethod.POST)
    public boolean loginAdminAccount(@RequestParam String adminId, @RequestParam String userPassword) {
    	//adminId = "admin01";
    	//userPassword="admin1111";
    	System.out.println(adminId);
    	System.out.println(userPassword);
        return validateAdminAccountService.doesAdminAccountExist(adminId, userPassword);
    }
   
    
	    
}
