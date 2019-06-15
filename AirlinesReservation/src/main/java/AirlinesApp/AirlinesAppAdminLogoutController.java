package AirlinesApp;

import AirlinesApp.AirlinesServiceLayer.client.SetUserLoginStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirlinesAppAdminLogoutController {

    @Autowired
    private SetUserLoginStatusService setUserLoginStatusService;

    @ResponseBody
    @RequestMapping(value = "/logout-admin", method = RequestMethod.POST)
    public boolean loginAdminAccount(@RequestParam String adminId) {
        System.out.println(adminId);
        return setUserLoginStatusService.setAdminLoginStatusFalse(adminId);
    }
}
