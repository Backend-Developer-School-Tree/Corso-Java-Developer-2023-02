package org.tree.javacourse.model;

public class User {

    private String username;
    private String ID;

    public User(String username, String iD) {
        this.username = username;
        ID = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", ID=" + ID + "]";
    }

}
