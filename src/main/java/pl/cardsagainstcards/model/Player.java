package pl.cardsagainstcards.model;

import java.io.Serializable;
import java.util.Date;

public class Player implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date lastseen;
    private Boolean enabled;
    private Boolean webadmin;

    public Player() {
        this (null, null, null, null, null, null, null);
    }

    public Player(Integer id, String username, String password, String email, Date lastseen, Boolean enabled, Boolean webadmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastseen = lastseen;
        this.enabled = enabled;
        this.webadmin = webadmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastseen() {
        return lastseen;
    }

    public void setLastseen(Date lastseen) {
        this.lastseen = lastseen;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getWebadmin() {
        return webadmin;
    }

    public void setWebadmin(Boolean webadmin) {
        this.webadmin = webadmin;
    }
}
