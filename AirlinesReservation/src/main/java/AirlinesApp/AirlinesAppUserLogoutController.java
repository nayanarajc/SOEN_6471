package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.client.SetUserLoginStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirlinesAppUserLogoutController {

    @Autowired
    private SetUserLoginStatusService setUserLoginStatusService;

    @ResponseBody
    @RequestMapping(value = "/logout-user", method = RequestMethod.POST)
    public boolean loginAdminAccount(@RequestParam String userEmail) {
        System.out.println(userEmail);
        return setUserLoginStatusService.setUserLoginStatusFalse(userEmail);
    }

}
