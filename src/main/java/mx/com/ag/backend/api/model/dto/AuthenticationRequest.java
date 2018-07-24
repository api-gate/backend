package mx.com.ag.backend.api.model.dto;

/**
 * @author Alejandro Luna
 * Date: 24/07/2018
 */
public class AuthenticationRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
