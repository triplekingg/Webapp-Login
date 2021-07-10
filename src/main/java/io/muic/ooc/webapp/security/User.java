package io.muic.ooc.webapp.security;

public class User {

    private String username;
    private String password;
    private String displayName;
    private long id;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id, String username, String password, String displayname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
