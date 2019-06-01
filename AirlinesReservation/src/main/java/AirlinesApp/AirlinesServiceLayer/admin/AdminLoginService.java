package AirlinesApp.AirlinesServiceLayer.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlinesApp.AirlinesDAOLayer.admin.AdminLogin;
import AirlinesApp.AirlinesDAOLayer.admin.AdminLoginDAO;

@Service
public class AdminLoginService {

    @Autowired
    private AdminLoginDAO adminLoginDAO;

    public List<AdminLogin> getAllAdminLogins() {
        List<AdminLogin> adminLogins = new ArrayList<>();
        adminLoginDAO.findAll().forEach(adminLogins::add);
        return adminLogins;
    }
}
