package io.deep27soft.jwstutorials.accounts;

public class UserProfile {

    private final String login;
    private final String pass;
    private final String email;

    public UserProfile(String login) {
        if (login == null) {
            throw new IllegalStateException("Login cannot be null!");
        }
        this.login = login;
        this.pass = login;
        this.email = login;
    }

    public UserProfile(String login, String pass, String email) {
        if (login == null || pass == null) {
            throw new IllegalStateException("Login and password cannot be null!");
        }
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }
}
