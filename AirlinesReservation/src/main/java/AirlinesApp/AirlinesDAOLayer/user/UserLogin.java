package AirlinesApp.AirlinesDAOLayer.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "user_logins"
)
public class UserLogin {

    private String userId;

    private String dob;

    private boolean isLoggedIn;

    @Id
    private String userEmail;

    private String userPassword;

    public UserLogin() {
    }

    public UserLogin(String userId, String userEmail, String userPassword, String dob, boolean isLoggedIn) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.dob = dob;
        this.isLoggedIn = isLoggedIn;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
