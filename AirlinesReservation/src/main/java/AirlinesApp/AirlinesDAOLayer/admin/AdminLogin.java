package AirlinesApp.AirlinesDAOLayer.admin;

import AirlinesApp.AirlinesDAOLayer.client.Person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "admin_logins"
)
public class AdminLogin extends Person {

    @Id
    private String adminId;

    private String adminPassword;

    private boolean isLoggedIn;

    public AdminLogin() {
    }

    public AdminLogin(String adminId, String adminPassword, boolean isLoggedIn) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.isLoggedIn = isLoggedIn;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
