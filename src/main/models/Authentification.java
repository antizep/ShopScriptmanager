package models;

public class Authentification {

    private String login;
    private long userId;
    private String token;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object authentification){

        if (authentification == null || getClass() != authentification.getClass()) return false;

        Authentification a = (Authentification) authentification;

        return a.getUserId() == this.getUserId() && a.getToken().equals(getToken());
    }
}
