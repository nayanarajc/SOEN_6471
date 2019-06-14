package AirlinesApp.AirlinesServiceLayer.user;

import AirlinesApp.AirlinesDAOLayer.admin.AdminLogin;
import AirlinesApp.AirlinesDAOLayer.admin.AdminLoginDAO;
import AirlinesApp.AirlinesDAOLayer.user.UserLogin;
import AirlinesApp.AirlinesDAOLayer.user.UserLoginDAO;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetUserLoginStatusService {

    @Autowired
    private UserLoginDAO userLoginDAO;

    @Autowired
    private AdminLoginDAO adminLoginDAO;

    public boolean setUserLoginStatusTrue(String userEmail) {
        UserLogin userLogin = userLoginDAO.findById(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(UserLogin.class, userEmail));
        userLogin.setLoggedIn(true);
        userLoginDAO.save(userLogin);
        return userLogin.isLoggedIn();
    }

    public boolean setUserLoginStatusFalse(String userEmail) {
        UserLogin userLogin = userLoginDAO.findById(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(UserLogin.class, userEmail));
        userLogin.setLoggedIn(false);
        userLoginDAO.save(userLogin);
        return !userLogin.isLoggedIn();
    }

    public boolean setAdminLoginStatusTrue(String adminId) {
        AdminLogin adminLogin = adminLoginDAO.findById(adminId)
                .orElseThrow(() -> new ObjectNotFoundException(AdminLogin.class, adminId));
        adminLogin.setLoggedIn(true);
        adminLoginDAO.save(adminLogin);
        return adminLogin.isLoggedIn();
    }

    public boolean setAdminLoginStatusFalse(String adminId) {
        AdminLogin adminLogin = adminLoginDAO.findById(adminId)
                .orElseThrow(() -> new ObjectNotFoundException(AdminLogin.class, adminId));
        adminLogin.setLoggedIn(false);
        adminLoginDAO.save(adminLogin);
        return !adminLogin.isLoggedIn();
    }

}
