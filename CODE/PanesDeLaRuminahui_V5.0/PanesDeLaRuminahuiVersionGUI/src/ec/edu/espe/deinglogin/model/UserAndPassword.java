package ec.edu.espe.deinglogin.model;

/**
 *
 * 
 */
public class UserAndPassword {

    private String user;
    private String pasword;

    public UserAndPassword(String user, String pasword) {
        this.user = user;
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return "UserAndPassword: " + "\nuser: " + user + "\npassword: " + pasword;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

}
