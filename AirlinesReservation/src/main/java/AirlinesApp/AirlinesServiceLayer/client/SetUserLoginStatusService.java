package AirlinesApp.AirlinesServiceLayer.client;

import AirlinesApp.AirlinesDAOLayer.admin.AdminLogin;
import AirlinesApp.AirlinesDAOLayer.admin.AdminLoginDAO;
import AirlinesApp.AirlinesDAOLayer.client.ClientLogin;
import AirlinesApp.AirlinesDAOLayer.client.ClientLoginDAO;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetUserLoginStatusService {

    @Autowired
    private ClientLoginDAO clientLoginDAO;

    @Autowired
    private AdminLoginDAO adminLoginDAO;

    public boolean setUserLoginStatusTrue(String userEmail) {
        ClientLogin clientLogin = clientLoginDAO.findById(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(ClientLogin.class, userEmail));
        clientLogin.setLoggedIn(true);
        clientLoginDAO.save(clientLogin);
        return clientLogin.isLoggedIn();
    }

    public boolean setUserLoginStatusFalse(String userEmail) {
        ClientLogin clientLogin = clientLoginDAO.findById(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException(ClientLogin.class, userEmail));
        clientLogin.setLoggedIn(false);
        clientLoginDAO.save(clientLogin);
        return !clientLogin.isLoggedIn();
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
