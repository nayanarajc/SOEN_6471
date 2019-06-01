package AirlinesApp.AirlinesServiceLayer.admin;

import AirlinesApp.AirlinesDAOLayer.admin.AdminLogin;
import AirlinesApp.AirlinesDAOLayer.admin.AdminLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateAdminAccountService {

    @Autowired
    private AdminLoginDAO adminLoginDAO;

    public boolean doesAdminAccountExist(String adminId, String adminPassword) {
        List<AdminLogin> adminLogins = new ArrayList<>();
        adminLoginDAO.findAll().forEach(adminLogins::add);
        return adminLogins.stream()
                .anyMatch(adminLogin -> adminLogin.getAdminId().equalsIgnoreCase(adminId) && adminLogin.getAdminPassword().equals(adminPassword));
    }

    public List<AdminLogin> adminLogins (){
        List<AdminLogin> adminLogins = new ArrayList<>();
        adminLoginDAO.findAll().forEach(adminLogins::add);
        return adminLogins;
    }

}
